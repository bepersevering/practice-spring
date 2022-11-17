package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("OtAchWtrDataServiceDImpl")
@Service
public class OtAchWtrDataServiceDImpl implements OtAchWtrDataService {
    @Override
    public void addNewData() {
        System.out.println("D");
    }
}
