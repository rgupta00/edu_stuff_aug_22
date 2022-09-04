package com.bankapp.service;

import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

	@Override
	public String sendSms(String phoneNumber) {
		//logic to send sms
		return "sms is send!";
	}

}
