package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Planter;
import com.example.farmerassistant.Repository.PlanterRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlanterServiceTest {
    @InjectMocks
    private PlanterService planterService = new PlanterService();
    @Mock
    private PlanterRepository planterRepository;

    public PlanterServiceTest() {
    }

    @Test
    void testGetPlanter() {
        Planter planter = new Planter();
        planter.setPlanterHeight(100.0F);
        planter.setPlanterCapacity(50);
        planter.setPlanterColor(50);
        planter.setDrainageHoles(20);
        planter.setPlanterShaper("linear");
        planter.setPlanterStock(20);
        planter.setPlanterCost(100000);
        Optional<Planter> optionalPlanter = Optional.of(planter);
        Mockito.when(this.planterRepository.findById(1L)).thenReturn(optionalPlanter);
        Planter myPlanter = this.planterService.getPlanter(1L);
        Assertions.assertEquals(50, myPlanter.getPlanterColor());
    }
}
