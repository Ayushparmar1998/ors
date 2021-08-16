package in.co.rays.ors.test;

import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.UserModel;
import in.co.rays.ors.util.DataUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserModelTest {

	public static UserModel model = new UserModel();
	
	public static void main(String[] args) throws Exception  
	{
	
		testAdd();
		//testDelete();
		//testUpdate();  
		//testFindByPK();
		//testFindByLogin(); 
		//testGetRoles();
		//testSearch();
		 // testList();
		 // testAuthenticate();
		   // testRegisterUser();
		    // testchangePassword();
		     //testforgetPassword();
		//testresetPassword();
		
		//String newPassword = (new java.util.Date().getTime()).substring(0, 4);
		//System.out.println(new java.util.Date().getTime().substring(0, 4));
		//String newPassword = String.valueOf(new java.util.Date().getTime()).substring(9, 13);
	//System.out.println(newPassword);
	
	
	}
	
	
public static void testAdd() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		//Date d = new Date();
						
		UserBean ubean = new UserBean();
		
		ubean.setFirstName("santosh");
		ubean.setLastName("Agarwal");
		ubean.setLogin("san@gmail.com");
		ubean.setPassword("pass");
		ubean.setDob(sdf.parse("10/11/1999"));
		//ubean.setConfirmPassword("pass");
		ubean.setMobileNo("95465467");
		ubean.setRoleId(1);
//		ubean.setUnSuccessFull(2);
		ubean.setGender("male");
//		ubean.setLastLogin(DataUtility.getTimestamp(new Date().getTime()));
//		ubean.setLock("yes");
		ubean.setRoleName("Student");
		
		
		
		
		
		try {
			model.add(ubean);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

   public static void testDelete(){
	   
	      
	  UserBean bean = new UserBean();
	  
	  bean.setId(1);
	  
	  try {
		model.delete(bean);
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   
   public static void testUpdate() throws Exception{
	                 
	   UserBean bean = new UserBean();
//	   try {
//		bean=model.findByPK(2L);
//		System.out.println(bean+"pk() called");
//	} catch (ApplicationException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		Date d = new Date();
	   bean.setId(2);
	   bean.setFirstName("Deepak");
	   bean.setLastName("ughade");
	   bean.setLogin("deep@gmail.com");
	   bean.setPassword("987");
	   bean.setDob(sdf.parse("10/11/1999"));
	   
	   try {
		model.update(bean);
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DuplicateRecordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static void testFindByPK() {
       try {
           UserBean bean = new UserBean();
           long pk = 2;
           bean = model.findByPK(pk);
           if (bean == null) {
               System.out.println("Test Find By PK fail");
           }
           System.out.println(bean.getId());
           System.out.println(bean.getFirstName());
           System.out.println(bean.getLastName());
           System.out.println(bean.getLogin());
           System.out.println(bean.getPassword());
           System.out.println(bean.getDob());
           System.out.println(bean.getRoleId());
//           System.out.println(bean.getUnSuccessFullLogin());
           System.out.println(bean.getGender());
//           System.out.println(bean.getLastLogin());
//           System.out.println(bean.getLock());
       } catch (ApplicationException e) {
           e.printStackTrace();
       }

   }
   
   public static void testFindByLogin(){
	   
	   try{
		   UserBean bean = new UserBean();
		   bean= model.findByLogin("deep@gmail.com");
		   System.out.println("bean value is"+bean);
		   if(bean==null){
			   System.out.println("Test Find By PK fail");
		   }
		   
		   
			   System.out.println(bean.getId());
			   System.out.println(bean.getFirstName());
			   System.out.println(bean.getLastName());
	            System.out.println(bean.getLogin());
	            System.out.println(bean.getPassword());
	            System.out.println(bean.getDob());
	            System.out.println(bean.getRoleId());
//	            System.out.println(bean.getUnSuccessFullLogin());
	            System.out.println(bean.getGender());
//	            System.out.println(bean.getLastLogin());
//	            System.out.println(bean.getLock());
		   
		   
		   
	   }
	   catch(Exception e){
		   
	   }
   }
   
   public static void testGetRoles(){
	   
	   
		   UserBean bean = new UserBean();
		  List<UserBean> list = new ArrayList();
		   
		  bean.setRoleId(1L);
		  
       try {
		list= model.getRoles(bean);
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		   
		 
		  
		  Iterator it = list.iterator();
		  while(it.hasNext()){
			  bean=(UserBean)it.next();
			  
			  System.out.println(bean.getId());
			  System.out.println(bean.getFirstName());
			  System.out.println(bean.getLastName());
			  System.out.println(bean.getLogin());
              System.out.println(bean.getPassword());
              System.out.println(bean.getDob());
              System.out.println(bean.getRoleId());
//              System.out.println(bean.getUnSuccessFullLogin());
              System.out.println(bean.getGender());
//              System.out.println(bean.getLastLogin());
//              System.out.println(bean.getLock());
		  }
 		   
	   
	  
   }
   
   public static void testSearch(){
	   UserBean bean = new UserBean();
	   List al = new ArrayList<UserBean>();
	    
	   try {
		al= model.search(bean,0,0);
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	   bean.setId(2);
	   
	   Iterator it = al.iterator();
	   while(it.hasNext()){
		   bean=(UserBean)it.next();
		   System.out.println(bean.getId());
           System.out.println(bean.getFirstName());
           System.out.println(bean.getLastName());
           System.out.println(bean.getLogin());
           System.out.println(bean.getPassword());
           System.out.println(bean.getDob());
           System.out.println(bean.getRoleId());
//           System.out.println(bean.getUnSuccessFullLogin());
           System.out.println(bean.getGender());
//           System.out.println(bean.getLastLogin());
//           System.out.println(bean.getLock());
	   }
   }
		
      
   public static void testList(){
	
	   UserBean bean = new UserBean();
	   
	   List<UserBean> al = new ArrayList();
	   
	   try{
		   al = model.list(1,1);
		   
		   Iterator it = al.iterator();
		   while(it.hasNext()){
	 		   bean = (UserBean)it.next();
	      
	 		  System.out.println(bean.getId());
	          System.out.println(bean.getFirstName());
	          System.out.println(bean.getLastName());
	          System.out.println(bean.getLogin());
	          System.out.println(bean.getPassword());
	          System.out.println(bean.getDob());
	          System.out.println(bean.getRoleId());
//	          System.out.println(bean.getUnSuccessFullLogin());
	          System.out.println(bean.getGender());
//	          System.out.println(bean.getLastLogin());
//	          System.out.println(bean.getLock());

		   }

	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   
	     }
   
   public static void testAuthenticate() {

       try {
           UserBean bean = new UserBean();
           bean.setLogin("deep@gmail.com");
           bean.setPassword("987");
           bean = model.authenticate(bean.getLogin(), bean.getPassword());
           if (bean != null) {
               System.out.println("Successfully login");

           } else {
               System.out.println("Invalied login Id & password");
           }

       } catch (ApplicationException e) {
           e.printStackTrace();
       }
   }
   
   public static void testRegisterUser(){
	   UserBean bean = new UserBean();
	   try{
		   
		   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		   
	   bean.setFirstName("Ankur");
	   bean.setLastName("agrawal");
	   bean.setLogin("ankur.agarwal.ggitm@gmail.com");
       bean.setPassword("1234 ");
       bean.setConfirmPassword("1234");
       bean.setDob(sdf.parse("11/20/2015"));
       bean.setGender("Male");
       bean.setRoleId(2);;
       long pk = model.registerUser(bean);
       System.out.println("Successfully register");
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }
   
   public static void testchangePassword(){
	   try{
		   UserBean bean = model.findByLogin("ankur.agarwal.ggitm@gmail.com");
		   
		      /* String oldPass=bean.getPassword();
		       * 
		       bean.setId(5);
		       bean.setPassword("ankur");
		       bean.setConfirmPassword("ankur");
		       
		       String newPass=bean.getPassword();*/
		       
		   
		       model.changePassword(5L,"ankur","ankit");
		       System.out.println("password has been change successfully");
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }
   
   public static void testforgetPassword(){
	   
	   try{
		   model.forgetPassword("ankur.agarwal.ggitm@gmail.com");
		   System.out.println("forget password successfully work");
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }
   
   /*public static void testresetPassword(){
	   try{
		   UserBean bean=model.findByLogin("ankur.agarwal.ggitm@gmail.com");
	   
	         model.resetPassword(bean);
	         System.out.println("password reset");
	   
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }*/
}


