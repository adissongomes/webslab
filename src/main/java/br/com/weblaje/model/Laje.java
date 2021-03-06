package br.com.weblaje.model;

import br.com.weblaje.table.AreaAcoValues.AreaAcoData;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Laje {

	public enum CAA {
        I(20), II(25), III(35), IV(45);
        private int tamanho;

        CAA(int tamanho) {
            this.tamanho = tamanho;
        }

        /** Assume os seguintes valores segundo NBR 6118
         * <pre>  I - 20mm</pre>
         * <pre> II - 25mm</pre>
         * <pre>III - 35mm</pre>
         * <pre> IV - 45mm</pre>
         * @return tamanho em milimetros
         */
        public int getTamanho() {
            return tamanho;
        }

        public double getTamanhoEmMetro() {
            return (double) tamanho / 1000;
        }
    }

    public enum Classe {
        DIRECAO_UNICA, DIRECAO_DUPLA
    }

    /**
     * Classe da laje
     */
    public static final int DIRECAO_SIMPLES = 1;

    /**
     * Classe da laje
     */
    public static final int DIRECAO_DUPLA = 2;

    private final double lx;

    private final double ly;

    private boolean balanco;

    /**
     * NBR 6118
     * 0.07m, 0.10m, 0.12m
     */
    private final double altura;

    private final Agregado agregado;

    private final double espessuraConcreto;

    private final double espessuraArgamassa;

    /**
     * Espessura do piso
     */
    private final double espessuraMaterial;

    @Builder.Default
    private final PesosEspecificos pesosEspecificos = PesosEspecificos.builder().build();

    @Builder.Default
    private Limites limites = Limites.builder().build();

    /**
     * Classe de agressividade
     * @see CAA#getTamanho()
     */
    @Builder.Default
    private CAA caa = CAA.II;

    private BigDecimal lambda;

    /**
     * lambda > 2: ARMADO EM UMA DIRECAO
     * lambda <= 2: ARMADO EM DUAS DIRECOES
     */
    @Builder.Default
    private Classe classe = Classe.DIRECAO_UNICA;

    @Builder.Default
    private Aco aco = Aco.CA50;

    /**
     * Unidade MPa
     */
    @Builder.Default
    private int fck = 25;

    @Builder.Default
    private double q = 1.5;

    private Carregamento carregamento;

    private Momento momento;

    private Armadura armadura;

    private AreaAcoData dadosArmaduraLx;

    private AreaAcoData dadosArmaduraLy;

    private Flecha flecha;

    private String n1;

    private String n2;

    private double alpha;
}
