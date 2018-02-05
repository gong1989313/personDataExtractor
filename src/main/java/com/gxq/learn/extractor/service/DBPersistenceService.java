package com.gxq.learn.extractor.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gxq.learn.extractor.dao.DBPersistenceDao;
import com.gxq.learn.extractor.pojo.Person;

public class DBPersistenceService {
	private DBPersistenceDao dao = new DBPersistenceDao();
	List<Person> personList = new ArrayList<Person>();
	
	public void persistence(String[] parms) {
		if(parms == null) {
			return;
		}
		if(personList.size() < 100) {
			Person p = packageObject(parms);
			if(p != null) {
				personList.add(p);
			}
		}else {
			try {
				dao.batchInsert(personList);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				personList.clear();
			}
		}
	}
	
	private Person packageObject(String[] parms) {
		Person p = new Person();
		p.setName(parms[0]);
		p.setCardno(parms[1]);
		p.setDescriot(parms[2]);
		p.setCtftp(parms[3]);
		p.setCtfId(parms[4]);
		p.setGender(parms[5]);
		p.setBirthday(parms[6]);
		p.setAddress(parms[7]);
		p.setZip(parms[8]);
		p.setDirty(parms[9]);
		p.setDistrct1(parms[10]);
		p.setDistrct2(parms[11]);
		p.setDistrct3(parms[12]);
		p.setDistrct4(parms[13]);
		p.setDistrct5(parms[14]);
		p.setDistrct6(parms[15]);
		p.setFirstnm(parms[16]);
		p.setLastnm(parms[17]);
		p.setDuty(parms[18]);
		p.setMobile(parms[19]);
		p.setTel(parms[20]);
		p.setFax(parms[21]);
		p.setEmail(parms[22]);
		p.setNation(parms[23]);
		p.setTaste(parms[24]);
		p.setEducation(parms[25]);
		p.setCompany(parms[26]);
		p.setCtel(parms[27]);
		p.setCaddress(parms[28]);
		p.setCzip(parms[29]);
		p.setFamily(parms[30]);
		p.setVersion(parms[31]);
		if(!StringUtils.equalsIgnoreCase(p.getAddress(), "Address")) {
			return p;
		}
		return null;
	}
}
