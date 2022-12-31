CREATE DATABASE bookstore;
USE bookstore;
/*user（用户）表*/
CREATE TABLE USER(
  id INT(11) NOT NULL AUTO_INCREMENT,    /*主键*/
  username VARCHAR(20) NOT NULL,			/*用户名*/
  PASSWORD VARCHAR(20) NOT NULL,			/*密码*/
  gender VARCHAR(2),			/*性别*/
  email VARCHAR(50),			/*邮箱*/
  telephone VARCHAR(20),			/*联系电话*/
  introduce VARCHAR(100),		/*个人介绍*/
  activeCode VARCHAR(50),		/*注册激活码*/
  state INT(11) DEFAULT 0,		/*用户状态，1：激活 0：未激活*/
  role VARCHAR(10) DEFAULT '普通用户',	/*用户角色:普通用户、超级用户*/
  registTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,/*注册时间*/
  PRIMARY KEY (id)
);

/*products（商品）表*/
CREATE TABLE products(
  id VARCHAR(100),		/*主键*/
  name VARCHAR(40),		/*商品名*/
  price DOUBLE,			/*商品价格*/
  category VARCHAR(40),		/*商品分类*/
  pnum INT(11),			/*商品库存*/
  imgurl VARCHAR(100),		/*商品图片地址*/
  description VARCHAR(255),	/*商品描述*/
  PRIMARY KEY (id)
);

/*orders（订单）表*/
CREATE TABLE orders (
  id VARCHAR(100) NOT NULL ,	/*主键*/
  money DOUBLE ,		/*订单价格*/
  receiverAddress VARCHAR(255) ,/*收货地址*/
  receiverName VARCHAR(20) ,	/*收货人姓名*/
  receiverPhone VARCHAR(20) ,	/*收货人电话*/
  paystate INT(11) DEFAULT 0,   /*订单状态，1：已支付 0：未支付*/
  ordertime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,/*订单生成时间*/
  user_id INT(11) ,		/*用户ID，关联users表中的主键*/
  PRIMARY KEY (id)
);

/*orderitem（订单项）表*/
CREATE TABLE orderitem (
  order_id VARCHAR(100) NOT NULL DEFAULT '',  /*主键，订单ID，关联orders表中的主键*/
  product_id VARCHAR(100) NOT NULL DEFAULT '',/*主键，商品ID，关联products表中的主键*/
  buynum INT(11) DEFAULT NULL,		      /*单个商品的购买数量*/
  PRIMARY KEY (order_id,product_id)
)

/*公告栏表*/
CREATE TABLE notice(
	n_id INT AUTO_INCREMENT PRIMARY KEY ,    /*主键*/
	title VARCHAR(10),						/*公告标题*/
	details VARCHAR(255),	 				/*公告内容*/
	n_time VARCHAR(18)						/*公告的发布和修改时间*/
);
---------------------------------------------------------------------