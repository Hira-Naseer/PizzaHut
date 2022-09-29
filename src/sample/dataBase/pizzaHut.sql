CREATE TABLE User
(
  userId INT(11) primary key,
  userName varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (userId)
);

CREATE TABLE customer
(
  customerId INT(11) not null primary key ,
  customerName varchar(255) NOT NULL,
  userId int(11) not null ,
  foreign key (userId) references user(userId)

);

CREATE TABLE Orders
(
  orderId INT not null,
  orderType varchar(255) NOT NULL ,
  customerId INT not null ,
  primary key (orderId),
  FOREIGN KEY (customerId) references customer (customerId)
);

CREATE TABLE product
(
  productId INT(11) primary key auto_increment,
  productName varchar(255) NOT NULL,
  productQuntity INT(11) NOT NULL,
  unitPrice float NOT NULL,
  productCode INT(11) NOT NULL

);

CREATE TABLE catagory
(
  catagoryId INT(11) primary key auto_increment,
  catagoryName varchar(255) NOT NULL,
  productId INT(11) NOT NULL,
  FOREIGN KEY (productId) REFERENCES product(productId)
);

CREATE TABLE inventory
(
  inventoryId INT(11) NOT NULL  primary key auto_increment,
  inventoryName varchar(255) not null ,
  quantity INT(11) NOT NULL,
  unitPrice float NOT NULL

);

CREATE TABLE supplier
(
  supplierId INT(11) primary key auto_increment,
  supplierName varchar(50) NOT NULL,
  phoneNo varchar(255) NOT NULL,
  inventoryId INT(11) NOT NULL,
  FOREIGN KEY (inventoryId) REFERENCES inventory(inventoryId)
);

CREATE TABLE customer_phoneNo
(
  phoneNo INT(11) NOT NULL,
  customerId INT(11) NOT NULL,
  PRIMARY KEY (phoneNo, customerId),
  FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

CREATE TABLE Employee
(
  employeeId INT primary key auto_increment,
  employeeName varchar(50) NOT NULL,
  depatment varchar(50) NOT NULL,
  inventoryId INT NOT NULL,
  FOREIGN KEY (inventoryId) REFERENCES inventory(inventoryId)
);

CREATE TABLE Employee_phoneNo
(
  phoneNo varchar(255) NOT NULL,
  employeeId INT(11) NOT NULL,
  PRIMARY KEY (phoneNo, employeeId),
  FOREIGN KEY (employeeId) REFERENCES Employee(employeeId)
);

CREATE TABLE Employee_adress
(
  adress varchar(255) NOT NULL,
  employeeId INT(11) NOT NULL,
  PRIMARY KEY (adress, employeeId),
  FOREIGN KEY (employeeId) REFERENCES Employee(employeeId)
);
