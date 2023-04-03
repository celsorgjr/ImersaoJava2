import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // Leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("/home/cjunior/Documents/alura/ImersaoJava2/stickers/entrada/TopMovies_1.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memoria com transparencia e com tamanho novo
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copia a imagem original para novo imagem (em memoria)
        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0, 0, null);

        //configurar fonte
        graphics.setColor(Color.yellow);
        graphics.setFont(new Font("Impact", Font.BOLD, 80));

        // escrever na nova imagem
        graphics.drawString("TOPZERA", 165, novaAltura -100);

        // escrever a nova imagem em uma arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}
