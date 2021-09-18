package com.sarbajit;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnRepo {
	private List<En> en_all;
	
	@PostConstruct
	private void giveAll() {
		this.en_all = new ArrayList<>();
		this.en_all.add(new En("Sarbajit",19,null));
		this.en_all.add(new En("Shalmoli",20,null));
		this.en_all.add(new En("Supriya",21,null));
	}
	
	public List<En> getAll(){
		return en_all;
	}
	
	public En delete(int roll) throws Exception {
		boolean notFound=true;
		List<En> enAll = this.getAll();
		En a = null;
		for(En e : enAll) {
			if (e.getRoll()==roll) { notFound=false; enAll.remove(e); a=e; break;}
		}
		
		if (notFound) {
			throw new Exception("No Such EN");
		}
		
		return a; 
	}

}
