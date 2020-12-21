package put.io.testing.mocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ExpenseManagerTest {
    private ExpenseManager manager;
    private ExpenseManager manager2;
    ExpenseRepository mockrep;
    FancyService mockdata;
    FancyService data;
    @BeforeEach
    void setUp() throws ConnectException{
        mockrep = mock(ExpenseRepository.class);
        mockdata = mock(FancyService.class);
        data = new FancyService();
        Expense e1 = new Expense(), e2 = new Expense(), e3 = new Expense();
        e1.setAmount(20);
        e2.setAmount(15);
        e3.setAmount(30);
        List<Expense> list = new ArrayList<Expense>();
        List<Expense> listcar = new ArrayList<Expense>();
        List<Expense> listhome = new ArrayList<Expense>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        listcar.add(e1);
        listcar.add(e3);
        listhome.add(e2);
        when(mockrep.getExpenses()).thenReturn(list);
        //kolejnosc ma znaczenie
        when(mockrep.getExpensesByCategory(anyString())).thenReturn(Collections.emptyList());
        when(mockrep.getExpensesByCategory("Car")).thenReturn(listcar);
        when(mockrep.getExpensesByCategory("Home")).thenReturn(listhome);
        when(mockdata.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(i -> (double)i.getArgument(0)/4.0);
        manager = new ExpenseManager(mockrep, mockdata);
        manager2 = new ExpenseManager(mockrep, data);

    }
    @Test
    public void testCalculateTotal(){
        long result = manager.calculateTotal();
        assertEquals(65, result);
    }
    @Test
    public void testCalculateTotalForCategory(){
        long result = manager.calculateTotalForCategory("Home");
        assertEquals(15, result);
        result = manager.calculateTotalForCategory("Car");
        assertEquals(50, result);
        result = manager.calculateTotalForCategory("aaa");
        assertEquals(0, result);
    }
    @Test
    public void testCalculateTotalInDollars() throws ConnectException{
        long result = manager.calculateTotalInDollars();
        verify(mockdata).convert(anyDouble(), eq("PLN"), eq("USD"));
        assertEquals(16.0, result);
    }
}
