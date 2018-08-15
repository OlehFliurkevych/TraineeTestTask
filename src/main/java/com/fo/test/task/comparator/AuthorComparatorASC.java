package com.fo.test.task.comparator;

import java.util.Comparator;

import com.fo.test.task.model.Author;

public class AuthorComparatorASC implements Comparator<Author>{

	@Override
	public int compare(Author o1, Author o2) {
		if(o1.getBorn()==null&&o2.getBorn()!=null) {
			return 1;
		}else if(o2.getBorn()==null&&o1.getBorn()!=null) {
			return -1;
		}
		if(o1.getBorn().getYear()>o2.getBorn().getYear()) {
			return 1;
		}else if(o1.getBorn().getYear()<o2.getBorn().getYear()) {
			return -1;
		}else if(o1.getBorn().getYear()==o2.getBorn().getYear()){
			if(o1.getBorn().getMonthValue()>o2.getBorn().getMonthValue()) {
				return 1;
			}else if(o1.getBorn().getMonthValue()<o2.getBorn().getMonthValue()) {
				return -1;
			}else if(o1.getBorn().getMonthValue()==o2.getBorn().getMonthValue()) {
				if(o1.getBorn().getDayOfMonth()>o2.getBorn().getDayOfMonth()) {
					return 1;
				}else if(o1.getBorn().getDayOfMonth()<o2.getBorn().getDayOfMonth()) {
					return -1;
				}
			}
		}
		return 0;
	}

}
