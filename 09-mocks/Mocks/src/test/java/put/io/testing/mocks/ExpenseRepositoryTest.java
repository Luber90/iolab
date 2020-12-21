package put.io.testing.mocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseRepositoryTest {
    private ExpenseRepository rep;
    IFancyDatabase mockObject;
    @BeforeEach
    void setUp(){
        mockObject = mock(IFancyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());
        rep = new ExpenseRepository(mockObject);

    }
    @Test
    void testLoadExpenses(){
        rep.loadExpenses();
        InOrder inOrder = inOrder(mockObject);
        inOrder.verify(mockObject).connect();
        inOrder.verify(mockObject).queryAll();
        inOrder.verify(mockObject).close();
        assertTrue(rep.getExpenses().isEmpty());
    }
    @Test
    void testSaveExpenses(){
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.saveExpenses();
        verify(mockObject, times(5)).persist(any(Expense.class));
    }
}
