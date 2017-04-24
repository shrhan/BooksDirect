package org.books.direct.dto;

import org.books.direct.enums.appdirect.NoticeTypeEnum;

public class Notice {

   private NoticeTypeEnum noticeType;

   private String message;

   public NoticeTypeEnum getNoticeType() {
      return noticeType;
   }

   public void setNoticeType(NoticeTypeEnum noticeType) {
      this.noticeType = noticeType;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

}
