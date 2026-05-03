package com.gordon.learning.stub.case2;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getUserDisplayName(long id) {
        User user = repository.findById(id);
        if (user == null) {
            return "訪客";
        }
        return "會員：" + user.getName();
    }

}
