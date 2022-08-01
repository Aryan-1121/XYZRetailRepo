package com.xyzretail.bean;


import java.sql.Date;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DateTime {
	private Timestamp time;
	private Date date;
	
	
}
