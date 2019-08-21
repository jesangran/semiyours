package mypage.model.vo;

import java.sql.Date;

public class Pick {
   private int pickNo;
   private int userNo;
   private Date pickDate;
   private int dealNo;
   
   public Pick() {}
   
   

   public Pick(int pickNo, int userNo, Date pickDate, int dealNo) {
      super();
      this.pickNo = pickNo;
      this.userNo = userNo;
      this.pickDate = pickDate;
      this.dealNo = dealNo;
   }



   public Pick(int pickNo, int userNo) {
      super();
      this.pickNo = pickNo;
      this.userNo = userNo;
   }



   public int getPickNo() {
      return pickNo;
   }

   public void setPickNo(int pickNo) {
      this.pickNo = pickNo;
   }

   public int getUserNo() {
      return userNo;
   }

   public void setUserNo(int userNo) {
      this.userNo = userNo;
   }

   public Date getPickDate() {
      return pickDate;
   }

   public void setPickDate(Date pickDate) {
      this.pickDate = pickDate;
   }

   public int getDealNo() {
      return dealNo;
   }

   public void setDealNo(int dealNo) {
      this.dealNo = dealNo;
   }
   
   @Override
   public String toString() {
      return "Pick [pickNo=" + pickNo + ", userNo=" + userNo + ", pickDate=" + pickDate + ", dealNo=" + dealNo + "]";
   }
   
}