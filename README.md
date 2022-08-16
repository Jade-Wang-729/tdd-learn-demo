## tdd-learn-demo
### tdd-card-user
```markdown
模拟第三方卡片验证服务，包含以下内容
1. 卡片的验证
   - 00，success
   - 01，invalid（卡片信息不匹配）
   - 02，inactive（卡片状态为非激活状态）
   - 03，locked（卡片状态为锁住状态）
2. 卡片持卡人信息的获取
   - 持卡人唯一标识cardNo
3. 卡片，持卡人信息以及关系的存储
```
### tdd-registration
```markdown
模拟用户注册服务，包含以下功能
1. 用户注册手段验证，验证失败，包装友好信息
2. 用户注册
3. 存储成功注册的用户信息
```
### story
用户通过卡片进行注册，卡片验证成功后，可以注册用户
1. 卡片信息：卡号(纯数字，19位)，pin码(纯数字，6位)
2. 匹配卡号和pin码，错误3次锁卡；在错误次数范围内验证成功，清除错误次数
3. 用户名密码注册，用户名大于6位小于32，密码大于8位小于24位，且用户名和持卡人唯一标识没有被使用可以注册成功
