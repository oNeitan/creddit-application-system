CREATE TABLE credit (
  id_credit BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   credit_code UUID NOT NULL,
   credit_value DECIMAL NOT NULL,
   day_first_instalment date NOT NULL,
   number_of_instalments INT NOT NULL,
   status INT NOT NULL,
   customer_id_customer BIGINT NOT NULL,
   CONSTRAINT pk_credit PRIMARY KEY (id_credit)
);

ALTER TABLE credit ADD CONSTRAINT FK_CREDIT_ON_CUSTOMER_ID_CUSTOMER FOREIGN KEY (customer_id_customer) REFERENCES customer (id_customer);