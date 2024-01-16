package com.kh.spring05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring05.dao.EmpDao;
import com.kh.spring05.dto.EmpDto;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpDao dao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute EmpDto dto) {
		dao.insert(dto);
		return "사원 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute EmpDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "사원정보 수정 완료";
		}
		else {
			return "등록되지 않은 사원 번호";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int empNo) {
		if(dao.delete(empNo)) {
			return "사원 번호 삭제 완료";
		}
		else {
			return "없는 사번입니다";
		}
	}
	
	//단순 목록
	@RequestMapping("/list")
	public String list() {
		List<EmpDto> list = dao.selectList();
		StringBuffer buffer = new StringBuffer();
		for(EmpDto dto : list) {
			buffer.append(dto.getEmpNo());
			buffer.append(",");
			buffer.append(dto.getEmpName());
			buffer.append(",");
			buffer.append(dto.getEmpDept());
			buffer.append(",");
			buffer.append(dto.getEmpDate());
			buffer.append(",");
			buffer.append(dto.getEmpSal());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	//항목 키워드 검색
	@RequestMapping("/list2")
	public String list2(
			@RequestParam String column,
			@RequestParam String keyword) {
		List<EmpDto> list = dao.selectList(column, keyword);
		StringBuffer buffer = new StringBuffer();
		for(EmpDto dto : list) {
			buffer.append(dto.getEmpNo());
			buffer.append(",");
			buffer.append(dto.getEmpName());
			buffer.append(",");
			buffer.append(dto.getEmpDept());
			buffer.append(",");
			buffer.append(dto.getEmpDate());
			buffer.append(",");
			buffer.append(dto.getEmpSal());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	//항목,목록 검색
	@RequestMapping("/list3")
	public String list3(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<EmpDto> list;
		if(isSearch) {
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		StringBuffer buffer = new StringBuffer();
		for(EmpDto dto : list) {
			buffer.append(dto.getEmpNo());
			buffer.append(",");
			buffer.append(dto.getEmpName());
			buffer.append(",");
			buffer.append(dto.getEmpDept());
			buffer.append(",");
			buffer.append(dto.getEmpDate());
			buffer.append(",");
			buffer.append(dto.getEmpSal());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
}
