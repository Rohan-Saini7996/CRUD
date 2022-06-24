package com.johnson.app.rest.Repository;

import com.johnson.app.rest.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel,Long> {
}
