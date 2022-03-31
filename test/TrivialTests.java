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
        sut.respuestaCorrecta();

        sut.tirarDado(1);

        boolean actual = sut.estaEnCarcel("Maria");

        Assertions.assertFalse(actual);
    }

    @Test
    public void con_respuesta_incorrecta_nunca_se_gana() throws Exception {
        Game sut = new Game("Maria", "Juan");

        sut.tirarDado(1);

        boolean esGanador = sut.respuestaIncorrecta();

        Assertions.assertFalse(esGanador);
    }

    @Test
    public void estando_en_la_carcel_nunca_se_gana() throws Exception {
        Game sut = new Game("Maria", "Juan");

        sut.tirarDado(1);
        sut.respuestaIncorrecta();

        sut.tirarDado(1);
        sut.respuestaCorrecta();

        boolean esGanador = sut.respuestaCorrecta();

        Assertions.assertFalse(esGanador);

    }

    @Test
    public void si_no_estoy_en_la_carcel_y_tengo_menos_de_6_monedas_no_gano() throws Exception {
        Game sut = new Game("Maria", "Juan");

        sut.tirarDado(1);

        boolean esGanador = sut.respuestaCorrecta();

        Assertions.assertFalse(esGanador);
    }

    @Test
    public void si_no_estoy_en_la_carcel_y_tengo_de_6_monedas_gano() throws Exception {
        Game sut = new Game("Maria", "Juan");
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);


        boolean esGanador = sut.respuestaCorrecta();

        Assertions.assertTrue(esGanador);
    }

    private void AcciertaMaria_FallaJuan(Game sut) throws Exception {
        sut.tirarDado(1);
        sut.respuestaCorrecta();
        sut.tirarDado(1);
        sut.respuestaIncorrecta();
    }
    @Test
    public void si_estoy_saliendo_de_la_carcel_y_tengo_de_6_monedas_gano() throws Exception {
        Game sut = new Game("Maria", "Juan");
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);
        AcciertaMaria_FallaJuan(sut);
        FallaMaria_FallaJuan(sut);


        boolean esGanador = sut.respuestaCorrecta();

        Assertions.assertTrue(esGanador);
    }

    private void FallaMaria_FallaJuan(Game sut) throws Exception{
      sut.tirarDado(1);
      sut.respuestaIncorrecta();

      sut.tirarDado(1);
      sut.respuestaIncorrecta();
    }
}

