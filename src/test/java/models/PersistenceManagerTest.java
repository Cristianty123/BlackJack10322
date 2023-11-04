
package models;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import persistance.PersistenceManager;

public class PersistenceManagerTest {
    private PersistenceManager persistenceManager;

    @Test
    public void testLoadGameWhenTheGameIsLoaded() {
      try {
            // Accede a la variable privada GAME_SAVE_FILE
            Field field = PersistenceManager.class.getDeclaredField("GAME_SAVE_FILE");
            field.setAccessible(true);
            field.set(persistenceManager, "game_save.json");

            // Simula el comportamiento de Paths.get para devolver la ubicación del archivo JSON existente
            Path filePath = Paths.get("game_save.json");
            when(Paths.get("game_save.json")).thenReturn(filePath);

             assertNotNull(persistenceManager.loadGame());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLoadGameWhenTheGameIsNotLoaded(){
    try {
            // Accede a la variable privada GAME_SAVE_FILE
            Field field = PersistenceManager.class.getDeclaredField("GAME_SAVE_FILE");
            field.setAccessible(true);
            field.set(persistenceManager, "game_save.json");

            // Simula el comportamiento de Paths.get para devolver la ubicación del archivo JSON existente
            Path filePath = Paths.get("game_save.json");
            when(Paths.get("game_save.json")).thenReturn(filePath);
            String json = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
            when(json.isEmpty()).thenReturn(true);

             assertEquals(null,persistenceManager.loadGame());
        } catch (Exception e) {
            e.printStackTrace();
        }    
    } 
}
