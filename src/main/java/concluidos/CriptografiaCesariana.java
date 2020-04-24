package concluidos;

import java.io.UnsupportedEncodingException;

public class CriptografiaCesariana {
    private static final int A_MINUSCULO = 97;
    private static final int Z_MINUSCULO = 122;
    private static final int NUM_CASA = 3;
    private static final int TOTAL_LETRAS = 26;

    public String criptografar(String texto) {
        verificaVazio(texto);
        byte byteMsg[] = transformaStringEmVetorDeByte(texto);
        for (int i = 0; i < byteMsg.length; i++) {
            if (byteMsg[i] > (A_MINUSCULO - 1) && byteMsg[i] < (Z_MINUSCULO + 1)) {
                if (byteMsg[i] + NUM_CASA > Z_MINUSCULO) byteMsg[i] -= TOTAL_LETRAS;
                byteMsg[i] += NUM_CASA;
            }
        }
        return tranformaVetorDeByteEmString(byteMsg);
    }

    public String descriptografar(String texto) {
        verificaVazio(texto);
        byte byteMsg[] = transformaStringEmVetorDeByte(texto);
        for (int i = 0; i < byteMsg.length; i++) {
            if (byteMsg[i] > (A_MINUSCULO - 1) && byteMsg[i] < (Z_MINUSCULO + 1)) {
                if (byteMsg[i] - NUM_CASA < A_MINUSCULO) byteMsg[i] += TOTAL_LETRAS;
                byteMsg[i] -= NUM_CASA;
            }
        }
        return tranformaVetorDeByteEmString(byteMsg);
    }

    private void verificaVazio(String texto) {
        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] transformaStringEmVetorDeByte(String texto) {
        return texto.toLowerCase().getBytes();
    }

    private String tranformaVetorDeByteEmString(byte[] byteArray) {
        try {
            return new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

