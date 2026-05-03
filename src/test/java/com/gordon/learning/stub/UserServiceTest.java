package com.gordon.learning.stub;

import com.gordon.learning.stub.case2.User;
import com.gordon.learning.stub.case2.UserRepository;
import com.gordon.learning.stub.case2.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Test
    void testGetUserFullNameIfExists() {

        // Step 1: Arrange
        UserRepository mockRepository = Mockito.mock(UserRepository.class);

        // create a user mock data
        User fakeUser = new User(101L, "Gordon", "Cheng");

        // Stub: When being inquired with ID 101, return this fake user.
        // Do not care about somebody in Database, only whether logic is correct if somebody is returned.
        // 不關心資料庫裡真的有誰，我們只關心「如果資料庫回傳某人，我們的邏輯對不對」。
        when(mockRepository.findById(101L)).thenReturn(fakeUser);

        // Step 2: Action
        UserService service = new UserService(mockRepository);
        String name = service.getUserDisplayName(101L);

        // Step 3: Assert
        assertEquals("會員：Gordon Cheng", name);

    }

    @Test
    void testGetUserFullNameIfNotExists() {
        // Step 1: Arrange
        UserRepository mockRepository = Mockito.mock(UserRepository.class);

        // Stub : Suppose the user is not found in DB, return null else.
        when(mockRepository.findById(999L)).thenReturn(null);


        // Step 2: Action
        UserService service = new UserService(mockRepository);
        String name = service.getUserDisplayName(999L);

        // Step 3: Assert
        assertEquals("訪客", name);

        // Another case, do step 1 for arrange and step 2 do action.
        when(mockRepository.findById(anyLong())).thenReturn(new User(1L, "預設","用戶"));

        // Stub: suppose user is the default user.
        name = service.getUserDisplayName(1L);

        // Do step 3 for assertion.
        assertEquals("預設用戶", name);
    }
}
