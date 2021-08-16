package in.co.rays.ors.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.ors.bean.CourseBean;
import in.co.rays.ors.model.CourseModel;

public class CourseModelTest {

	public static CourseModel model = new CourseModel();

	public static void main(String[] args) throws Exception {

		 testAdd();
		// testUpdate();
		// testDelete();
		// testFindByName();
		//testFindByPk();
		//testSearch();
//		testList();
	}

	public static void testAdd() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setcName("BCOM");
		bean.setDuration("3 years");
		bean.setDescription(" Bachlor degree");
		bean.setCreatedBy("ADMIN");
		bean.setModifiedBy("ADMIN");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setId(2);
		bean.setcName("BTech1");
		bean.setDuration("4 years");
		bean.setDescription("Bachlor degree");
		bean.setCreatedBy("Ankit");
		bean.setModifiedBy("Ankit");

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setId(2);

		model.delete(bean);
	}

	public static void testFindByName() throws Exception {

		CourseBean bean = new CourseBean();

		bean = model.findByName("MTech");

		System.out.println(bean.getId());
		System.out.println(bean.getDescription());

	}

	public static void testFindByPk() throws Exception {

		CourseBean bean = new CourseBean();

		bean = model.findByPk(1);

		System.out.println(bean.getId());
		System.out.println(bean.getcName());
		System.out.println(bean.getDescription());

	}

	public static void testSearch() throws Exception{
		
		CourseBean bean = new CourseBean();
		
		List<CourseBean> list = new ArrayList<CourseBean>();
		
		 list=model.search(bean,0,0);
		 
		 Iterator<CourseBean> it = list.iterator();
		 
		 while(it.hasNext()){
			      bean = it.next();
	 		   System.out.println(bean.getId());
				System.out.println(bean.getcName());
				System.out.println(bean.getDescription());
				System.out.println(bean.getDuration());
			 
		 }
	}
	
public static void testList() throws Exception{
		
		CourseBean bean = new CourseBean();
		
		List<CourseBean> list = new ArrayList<CourseBean>();
		
		 list=model.list(0,0);
		 
		 Iterator<CourseBean> it = list.iterator();
		 
		 while(it.hasNext()){
			      bean = it.next();
	 		   System.out.println(bean.getId());
				System.out.println(bean.getcName());
				System.out.println(bean.getDescription());
				System.out.println(bean.getDuration());
			    System.out.println(bean.getCreatedBy());
		 }
	}
}
