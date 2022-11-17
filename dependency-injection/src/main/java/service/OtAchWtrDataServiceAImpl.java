package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("OtAchWtrDataServiceAImpl")
@Service
public class OtAchWtrDataServiceAImpl implements OtAchWtrDataService{
    @Override
    public void addNewData() {
        System.out.println("A");
    }
}
