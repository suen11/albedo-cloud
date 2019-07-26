/**
 * Copyright &copy; 2018 <a href="https://github.com/somewhereMrli/albedo-boot">albedo-boot</a> All rights reserved.
 */
package com.albedo.java.modules.test.domain;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import com.albedo.java.common.core.annotation.SearchField;
import com.albedo.java.common.persistence.domain.IdEntity;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import com.albedo.java.common.core.annotation.DictType;
import java.util.Date;


import javax.validation.constraints.*;

/**
 * 测试书籍管Entity 测试书籍
 * @author sys
 * @version 2019-07-25 21:24:51
 */
@TableName(value = "test_book")
@Data @ToString @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TestBook extends IdEntity<TestBook> {

	private static final long serialVersionUID = 1L;
	/** F_TITLE title_  :  标题 */
	public static final String F_TITLE = "title";
	/** F_SQL_TITLE title_  :  标题 */
	public static final String F_SQL_TITLE = "title_";
	/** F_AUTHOR author_  :  作者 */
	public static final String F_AUTHOR = "author";
	/** F_SQL_AUTHOR author_  :  作者 */
	public static final String F_SQL_AUTHOR = "author_";
	/** F_NAME name_  :  名称 */
	public static final String F_NAME = "name";
	/** F_SQL_NAME name_  :  名称 */
	public static final String F_SQL_NAME = "name_";
	/** F_EMAIL email_  :  邮箱 */
	public static final String F_EMAIL = "email";
	/** F_SQL_EMAIL email_  :  邮箱 */
	public static final String F_SQL_EMAIL = "email_";
	/** F_PHONE phone_  :  手机 */
	public static final String F_PHONE = "phone";
	/** F_SQL_PHONE phone_  :  手机 */
	public static final String F_SQL_PHONE = "phone_";
	/** F_ACTIVATED activated_  :  activated_ */
	public static final String F_ACTIVATED = "activated";
	/** F_SQL_ACTIVATED activated_  :  activated_ */
	public static final String F_SQL_ACTIVATED = "activated_";
	/** F_NUMBER number_  :  key */
	public static final String F_NUMBER = "number";
	/** F_SQL_NUMBER number_  :  key */
	public static final String F_SQL_NUMBER = "number_";
	/** F_MONEY money_  :  money_ */
	public static final String F_MONEY = "money";
	/** F_SQL_MONEY money_  :  money_ */
	public static final String F_SQL_MONEY = "money_";
	/** F_AMOUNT amount_  :  amount_ */
	public static final String F_AMOUNT = "amount";
	/** F_SQL_AMOUNT amount_  :  amount_ */
	public static final String F_SQL_AMOUNT = "amount_";
	/** F_RESETDATE reset_date  :  reset_date */
	public static final String F_RESETDATE = "resetDate";
	/** F_SQL_RESETDATE reset_date  :  reset_date */
	public static final String F_SQL_RESETDATE = "reset_date";

	//columns START
	/** title 标题 */@Size(max=32)@TableField("title_")
	private String title;
	/** author 作者 */@NotBlank @Size(max=50)@TableField("author_")
	private String author;
	/** name 名称 */@Size(max=50)@TableField("name_")@SearchField
	private String name;
	/** email 邮箱 */@Email @Size(max=100)@TableField("email_")
	private String email;
	/** phone 手机 */@Size(max=32)@TableField("phone_")
	private String phone;
	/** activated activated_ */@NotNull @TableField("activated_")@DictType("sys_flag")
	private Integer activated;
	/** number key */@TableField("number_")
	private Long number;
	/** money money_ */@TableField("money_")
	private Double money;
	/** amount amount_ */@TableField("amount_")
	private Double amount;
	/** resetDate reset_date */@TableField("reset_date")
	private Date resetDate;
	//columns END

	@Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}