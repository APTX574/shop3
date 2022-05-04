package com.community.entity;

import java.util.Date;
import java.util.Objects;

public class Goods {
	private int id;
	private String title;
	private String imgUrl;
	private String content;
	private double price;
	private Date createTime;
	private int status;

	public Goods() {
	}

	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", title='" + title + '\'' +
				", imgUrl='" + imgUrl + '\'' +
				", content='" + content + '\'' +
				", price=" + price +
				", createTime=" + createTime +
				", status=" + status +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Goods goods = (Goods) o;
		return id == goods.id && Double.compare(goods.price, price) == 0 && status == goods.status && Objects.equals(title, goods.title) && Objects.equals(imgUrl, goods.imgUrl) && Objects.equals(content, goods.content) && Objects.equals(createTime, goods.createTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, imgUrl, content, price, createTime, status);
	}

	public Goods(int id, String title, String imgUrl, String content, double price, Date createTime, int status) {
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.price = price;
		this.createTime = createTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
