1. SET UP
AC: postgreSql 初始化成功
GIVEN postgre config files ，WHEN run main app ，THEN create table and history table
manually check
AC: Tables
card: cardNo(PK),pin,status
card_user_relation: cardNo(PK),user name, user phone
verification: cardNo(PK), verification


2. ADMIN
- ADD CARD
AC: 录入新的卡片信息

a. GIVEN new card ，WHEN add card ，THEN insert new card info into card tables
controller: GIVEN new card request，WHEN add card ，THEN response 200 with new card full info with 'inactive' status
service: GIVEN new card entity，WHEN add card ，THEN return entity with status
repository: GIVEN new card values，WHEN add card ，THEN insert new card info into card tables

b. GIVEN old card ，WHEN add card ，THEN insert fail
controller: GIVEN old card request，WHEN add card ，THEN response 400 with error message (this card has already added)
service: GIVEN old card entity，WHEN add card ，THEN throw exception with message (this card has already added)

c. GIVEN invalid card info，WHEN add card ，THEN insert fail
controller: GIVEN invalid card request，WHEN add card ，THEN response 400 with error message (sorry, wrong card information)
service: GIVEN invalid card entity，WHEN add card ，THEN throw exception with message (sorry, wrong card information)

- REMOVE CARD
AC: 删除失效的卡片信息
a. GIVEN existing card to delete，WHEN remove card ，THEN delete success
controller: GIVEN existing card request，WHEN remove card ，THEN response 200
service: GIVEN existing card entity，WHEN remove card ，THEN return success
repository: GIVEN existing card ，WHEN remove card ，THEN delete card info from two card
b. GIVEN wrong card to delete，WHEN remove card ，THEN delete fail
controller: GIVEN wrong card request，WHEN remove card ，THEN 400 with error message (sorry, wrong card information)
service: GIVEN wrong card entity，WHEN remove card ，THEN throw exception with error message (sorry, wrong card information)

- ADD USER
AC: 将卡片和用户信息捆绑
a. GIVEN existing card to add，WHEN add user ，THEN add success
controller: GIVEN new card add user request，WHEN add，THEN response 200 with new card added user full info
service: GIVEN new card add user card entity，WHEN add，THEN return entity
repository: GIVEN new card add user values，WHEN add，THEN insert new card info into card-user tables


3. USER
- verification
AC: 用户通过卡片进行注册，卡片验证成功后，可以注册用户
a. GIVEN right card and its pin，WHEN verify ，THEN card_status becomes active, response message (card verified successfully)
b. GIVEN wrong info，WHEN verify
  - wrong once, THEN verification plus 1, response message (invalid card information, verification failed, two chance left)
  - wrong three times, verification plus 1 every time, THEN card_status becomes locked, response message (invalid card information, verification failed, this card has been locked)
  - wrong then right, THEN verification return 0, card_status becomes active, response message (card verified successfully)

