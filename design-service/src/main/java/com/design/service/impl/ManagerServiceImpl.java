package com.design.service.impl;

import com.design.dao.*;
import com.design.model.StudentCourseModel;
import com.design.pojo.CollegeMajorInfo;
import com.design.pojo.CourseInfo;
import com.design.pojo.StudentInfo;
import com.design.pojo.TeacherInfo;
import com.design.service.ManagerService;
import com.design.util.annotaion.LogAuto;
import com.design.util.biz.LogBiz;
import com.design.util.exception.GraduationDesignException;
import com.design.util.exception.ReturnCodeModel;
import com.design.util.utils.TinyUUIDGenerator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Ke Zhang on 2018/3/21.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private CollegeMajorInfoMapper collegeMajorInfoMapper;
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Autowired
    private CourseInfoMapper courseInfoMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Override
    @LogAuto(LogBiz.MANAGER_SYSTEM)
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int DoCourseSelectRegister(MultipartFile file) {
        Workbook workbook = parseFile(file);
        int numberOfSheets = workbook.getNumberOfSheets();
        List<CourseInfo> list = new ArrayList<>();
        String studyYear = null;
        Integer semester = null;
        for(int i = 0; i < numberOfSheets; i++){
            Sheet sheet = workbook.getSheetAt(i);
            //获取行迭代器
            Iterator<Row> rowIterator = sheet.iterator();
            int rowIndex = -1;
            //循环每一行
            while(rowIterator.hasNext()){
                CourseInfo courseInfo = new CourseInfo();
                Row row = rowIterator.next();
                rowIndex ++;
                if(rowIndex == 0){
                    String value = row.getCell(0).getStringCellValue();
                    //s = '2017-2018-1'
                    String s = value.trim().substring(0, 11);
                    studyYear = s.substring(0, 9);
                    semester = Integer.parseInt(s.substring(10, 11));
                    continue;
                }
                if(rowIndex == 1){
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                int columnIndex = 0;
                List<String> studentIds = new ArrayList<>();
                //遍历每一列
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    String value = cell.getStringCellValue();
                    if(!StringUtils.isEmpty(value)){
                        switch (columnIndex){
                            case 0 : courseInfo.setCourseName(value); break;
                            case 1 : courseInfo.setTeacherName(value); break;
                            case 2 : courseInfo.setWeeklyStudyTime(value); break;
                            case 3 : courseInfo.setWeeklyStartEnd(value); break;
                            case 4 : courseInfo.setCredits(Float.parseFloat(value)); break;
                            case 5 : courseInfo.setClassTime(value); break;
                            case 6 : courseInfo.setClassPlace(value); break;
                            case 7 : courseInfo.setTotalStudyTime(Integer.parseInt(value)); break;
                            case 8 : courseInfo.setClassroomStudyTime(Integer.parseInt(value)); break;
                            case 9 : courseInfo.setExperimentStudyTime(Integer.parseInt(value)); break;
                            case 10 : courseInfo.setComputerStudyTime(Integer.parseInt(value)); break;
                            case 11 : courseInfo.setStudentCount(Integer.parseInt(value)); break;
                            case 12 : courseInfo.setClassNature(value); break;
                            case 13 : courseInfo.setInspectionWay(value); break;
                            case 14 :
                                String[] className = value.split(",");
                                for(String name : className){
                                    name = name.trim();
                                    String clazz = name.substring(name.length() - 4);
                                    String major = name.substring(0, name.length() - 4);
                                    StudentInfo record = new StudentInfo();
                                    record.setStuClass(clazz);
                                    //设置专业---
                                    record.setMajorId(collegeMajorInfoMapper.selectIdByName(major));
                                    studentIds.addAll(studentInfoMapper.selectIdsByModel(record));
                                }
                                break;
                            default:
                        }
                    }
                    columnIndex ++;
                }
                if(!StringUtils.isEmpty(courseInfo.getCourseName())){
                    courseInfo.setCourseId(TinyUUIDGenerator.generate());
                    courseInfo.setStudyYear(studyYear);
                    courseInfo.setSemester(semester);
                    list.add(courseInfo);
                    List<StudentCourseModel> idList = new ArrayList<>(studentIds.size());
                    for(String id : studentIds){
                        StudentCourseModel model = new StudentCourseModel();
                        model.setId(TinyUUIDGenerator.generate());
                        model.setStudentId(id);
                        model.setCourseId(courseInfo.getCourseId());
                        idList.add(model);
                    }
                    if(idList.size() != 0){
                        studentCourseMapper.addBatch(idList);
                    }
                }
            }
        }
        int size = list.size();
        if(size == 0){
            return 0;
        }
        courseInfoMapper.addBatch(list);
        return size;
    }

    @Override
    @LogAuto(LogBiz.MANAGER_SYSTEM)
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int DoCollegeMajorRegister(MultipartFile file) {
        Workbook workbook = parseFile(file);
        int numberOfSheets = workbook.getNumberOfSheets();
        List<CollegeMajorInfo> collegeMajorInfos = new ArrayList<>();
        for(int i = 0; i < numberOfSheets; i++){
            Sheet sheet = workbook.getSheetAt(i);
            //获取行迭代器
            Iterator<Row> rowIterator = sheet.iterator();
            int rowIndex = 0;
            //循环每一行
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                if(rowIndex == 0){
                    rowIndex ++;
                    continue;
                }
                rowIndex ++;
                Iterator<Cell> cellIterator = row.cellIterator();
                int columnIndex = 0;
                CollegeMajorInfo collegeMajorInfo = new CollegeMajorInfo();
                //遍历每一列
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    String value = cell.getStringCellValue();
                    if(!StringUtils.isEmpty(value)){
                        switch (columnIndex){
                            case 0 : collegeMajorInfo.setCmName(value); collegeMajorInfo.setFlag(1);break;
                            case 1 : collegeMajorInfo.setCmName(value); collegeMajorInfo.setFlag(2);break;
                            case 2 : collegeMajorInfo.setAbbName(value);break;
                            case 3 : collegeMajorInfo.setCollegeEn(value);break;
                            default:
                        }
                    }
                    columnIndex ++;
                }
                if(!StringUtils.isEmpty(collegeMajorInfo.getCmName())){
                    collegeMajorInfo.setCmId(TinyUUIDGenerator.generate());
                    collegeMajorInfo.setStatus(1);
                    collegeMajorInfos.add(collegeMajorInfo);
                }
            }
        }
        int size = collegeMajorInfos.size();
        if(size == 0){
            return 0;
        }
        collegeMajorInfoMapper.addBatch(collegeMajorInfos);
        return size;
    }

    @Override
    @LogAuto(LogBiz.MANAGER_SYSTEM)
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int DoStudentRegister(MultipartFile file) {
        Workbook workbook = parseFile(file);
        int numberOfSheets = workbook.getNumberOfSheets();
        List<StudentInfo> list = new ArrayList<>();
        for(int i = 0; i < numberOfSheets; i++){
            Sheet sheet = workbook.getSheetAt(i);
            //获取行迭代器
            Iterator<Row> rowIterator = sheet.iterator();
            int rowIndex = 0;
            //循环每一行
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                if(rowIndex == 0){
                    rowIndex ++;
                    continue;
                }
                rowIndex ++;
                Iterator<Cell> cellIterator = row.cellIterator();
                int columnIndex = 0;
                StudentInfo studentInfo = new StudentInfo();
                //遍历每一列
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    String value = cell.getStringCellValue();
                    if(!StringUtils.isEmpty(value)){
                        switch (columnIndex){
                            case 0 : studentInfo.setRealname(value);break;
                            case 1 : studentInfo.setStudentNumber(value);break;
                            case 2 : studentInfo.setCollegeId(collegeMajorInfoMapper.selectIdByName(value));break;
                            case 3 : studentInfo.setMajorId(collegeMajorInfoMapper.selectIdByName(value));break;
                            case 4 : studentInfo.setEntranceYear(value);break;
                            case 5 : studentInfo.setStuClass(value);break;
                            default:
                        }
                    }
                    columnIndex ++;
                }
                if(!StringUtils.isEmpty(studentInfo.getRealname())){
                    studentInfo.setUserId(TinyUUIDGenerator.generate());
                    //todo 密码加密
                    studentInfo.setPassword(studentInfo.getStudentNumber());
                    studentInfo.setEnable(1);
                    list.add(studentInfo);
                }
            }
        }
        int size = list.size();
        if(size == 0){
            return 0;
        }
        studentInfoMapper.addBatch(list);
        return size;
    }

    @Override
    @LogAuto(LogBiz.MANAGER_SYSTEM)
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int DoTeacherRegister(MultipartFile file) {
        Workbook workbook = parseFile(file);
        int numberOfSheets = workbook.getNumberOfSheets();
        List<TeacherInfo> list = new ArrayList<>();
        for(int i = 0; i < numberOfSheets; i++){
            Sheet sheet = workbook.getSheetAt(i);
            //获取行迭代器
            Iterator<Row> rowIterator = sheet.iterator();
            int rowIndex = 0;
            //循环每一行
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                if(rowIndex == 0){
                    rowIndex ++;
                    continue;
                }
                rowIndex ++;
                Iterator<Cell> cellIterator = row.cellIterator();
                int columnIndex = 0;
                TeacherInfo teacherInfo = new TeacherInfo();
                //遍历每一列
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    String value = cell.getStringCellValue();
                    if(!StringUtils.isEmpty(value)){
                        switch (columnIndex){
                            case 0 : teacherInfo.setRealname(value);break;
                            case 1 : teacherInfo.setTeacherNumber(value);break;
                            case 2 :
                                String collegeId = collegeMajorInfoMapper.selectIdByName(value);
                                if(StringUtils.isEmpty(collegeId)){
                                    throw new GraduationDesignException(ReturnCodeModel.EXCEL_DATA_ERROR);
                                }
                                teacherInfo.setCollegeId(collegeId);break;
                            default:
                        }
                    }
                    columnIndex ++;
                }
                if(!StringUtils.isEmpty(teacherInfo.getRealname())){
                    teacherInfo.setTeacherId(TinyUUIDGenerator.generate());
                    //todo 密码加密
                    teacherInfo.setPassword(teacherInfo.getTeacherNumber());
                    teacherInfo.setEnable(1);
                    list.add(teacherInfo);
                }
            }
        }
        int size = list.size();
        if(size == 0){
            return 0;
        }
        teacherInfoMapper.addBatch(list);
        return size;
    }

    private Workbook parseFile(MultipartFile file){
        if(file == null){
            throw new GraduationDesignException(ReturnCodeModel.PARAMETER_MISS);
        }
        String fileName = file.getOriginalFilename();
        Workbook workbook = null;
        //判断excel的两种格式xls,xlsx
        try {
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(file.getInputStream());
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(file.getInputStream());
            }
        } catch (IOException e) {
            throw new GraduationDesignException(ReturnCodeModel.EXCEL_READ_ERROR);
        }
        return workbook;
    }

    public static void main(String[] args){
        //s = '2017-2018-1'
        String s = "2017-2018-1";
        String studyYear = s.substring(0, 9);
        String semester = s.substring(9, 11);
        System.out.println(studyYear);
        System.out.println(semester);
    }
}
