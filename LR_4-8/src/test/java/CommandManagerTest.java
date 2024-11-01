import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import service.Command;
import service.CommandManager;


class CommandManagerTest {
    private CommandManager commandManager;
    private Command mockCommand;

    @BeforeEach
    void setUp() {
        commandManager = new CommandManager();
        mockCommand = mock(Command.class);  // Створюємо підмінену команду
    }

    @Test
    void testRunCommand_CallsExecuteOnCommand() {
        // Виконуємо команду
        commandManager.runCommand(mockCommand);

        // Перевіряємо, що метод execute() був викликаний один раз
        verify(mockCommand, times(1)).execute();
    }
}
