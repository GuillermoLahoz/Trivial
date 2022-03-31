import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smellytrivial.Game;

public class TrivialTests {
  @Test
    public void un_jugador_que_falla_va_a_la_carcel() throws Exception {
      Game sut = new Game("Maria", "Juan");
      sut.tirarDado(1);
      sut.respuestaIncorrecta();

      boolean actual = sut.estaEnCarcel("Maria");

      Assertions.assertTrue(actual);
  }
    @Test
    public void un_jugador_en_la_carcel_que_acierta_sale_de_la_carcel() throws Exception {
        Game sut = new Game("Maria", "Juan");
        sut.tirarDado(1);
        sut.respuestaIncorrecta();

        sut.tirarDado(1);
        sut.fueRespuestaCorrecta();

        sut.tirarDado(1);

        boolean actual = sut.estaEnCarcel("Maria");

        Assertions.assertFalse(actual);
    }
}
