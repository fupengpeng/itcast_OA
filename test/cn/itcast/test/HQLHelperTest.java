package cn.itcast.test;

import cn.itcast.oa.domain.User;
import cn.itcast.oa.utils.HQLHelper;

public class HQLHelperTest {
	
	
	public static void main(String[] args) {
		
		HQLHelper hh = new HQLHelper(User.class);
		hh.addWhere(" o.name = ? ", " zhangsan ");
		hh.addWhere(" o.age > ?  ", 20 );
		hh.addWhere(" o.address = ? ", " bj ");
		hh.addWhere(" o.tel is not null ");
		
		hh.addOrderBy(" o.name ", false);
		hh.addOrderBy(" o.age ", true);
		
		String listHQL = hh.getListHQL();
		String countHQL = hh.getCountHQL();
		
		System.out.println("listHQL  == " + listHQL);
		System.out.println("countHQL  == " + countHQL);
		System.out.println(hh.getArgs());
		
	}

}
