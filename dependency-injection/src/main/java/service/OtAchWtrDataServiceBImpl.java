package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("OtAchWtrDataServiceBImpl")
@Service
public class OtAchWtrDataServiceBImpl implements OtAchWtrDataService{
    @Override
    public void addNewData() {
        System.out.println("B");
    }
}
