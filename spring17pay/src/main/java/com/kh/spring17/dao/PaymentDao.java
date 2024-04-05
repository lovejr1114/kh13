package com.kh.spring17.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring17.dto.PaymentDetailDto;
import com.kh.spring17.dto.PaymentDto;

@Repository
public class PaymentDao {

	@Autowired
	private SqlSession sqlSession;
	
	//시퀀스
	public int paymentSequence() {
		return sqlSession.selectOne("payment.paymentSequence");
	}
	
	//페이먼트 등록
	public void insertPayment(PaymentDto paymentDto) {
		sqlSession.insert("payment.paymentAdd", paymentDto);
	}
	
	//페이먼트 디테일 시퀀스
	public int paymentDetailSequence() {
		return sqlSession.selectOne("payment.paymentDetailSequence");
	}
	//페이먼트디테일 등록
	public void insertPaymentDetail(PaymentDetailDto paymentDetailDto) {
		sqlSession.insert("payment.paymentDetailAdd", paymentDetailDto);
	}
	
	
	//페이먼트 조회
	public List<PaymentDto> paymentList(){
		return sqlSession.selectList("payment.paymentList");
	}
	//페이먼트 디테일 조회
	public List<PaymentDetailDto> paymentDetailList(int paymentNo){
		return sqlSession.selectList("payment.paymentDetailList", paymentNo);
	}

	//페이먼트 상세조회
	public PaymentDto selectOne(int paymentNo) {
		return sqlSession.selectOne("payment.paymentFind",paymentNo);
	}
	
	
}
