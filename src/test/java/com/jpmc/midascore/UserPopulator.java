package com.jpmc.midascore;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPopulator {

    @Autowired
    private FileLoader fileLoader;

    @Autowired
    private DatabaseConduit databaseConduit;

    public void populate() {
        String[] userLines = fileLoader.loadStrings("/target/test_classes/test_data/users.txt");//test/resources/test_data/users.txt
        for (String userLine : userLines) {
            String[] userData = userLine.split(", ");
            User user = new User(userData[0], Double.parseDouble(userData[1]));
            databaseConduit.save(user);
        }
    }

    
}

