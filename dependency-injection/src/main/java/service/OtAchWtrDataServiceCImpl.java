package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("OtAchWtrDataServiceCImpl")
@Service
public class OtAchWtrDataServiceCImpl implements OtAchWtrDataService{
    @Override
    public void addNewData() {
        System.out.println("C");
    }
}
