//package securitysm2;
//
//import org.bouncycastle.asn1.gm.GMNamedCurves;
//import org.bouncycastle.asn1.x9.X9ECParameters;
//import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
//import org.bouncycastle.crypto.engines.SM2Engine;
//import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
//import org.bouncycastle.crypto.params.ECDomainParameters;
//import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
//import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
//import org.bouncycastle.crypto.params.ECPublicKeyParameters;
//import org.bouncycastle.math.ec.ECPoint;
//import org.bouncycastle.util.encoders.Hex;
//
//import java.math.BigInteger;
//import java.security.SecureRandom;
//import java.util.Base64;
//
///**
// * @author ysf
// * @date 2020/10/9
// */
//public class A {
//
//    public static void pripub() throws Exception {
//        //生成密钥对
//        X9ECParameters sm2ECParameters = GMNamedCurves.getByName("sm2p256v1");
//        ECDomainParameters domainParameters = new ECDomainParameters(sm2ECParameters.getCurve(), sm2ECParameters.getG(), sm2ECParameters.getN());
//        ECKeyPairGenerator keyPairGenerator = new ECKeyPairGenerator();
//        keyPairGenerator.init(new ECKeyGenerationParameters(domainParameters, SecureRandom.getInstance("SHA1PRNG")));
//        AsymmetricCipherKeyPair asymmetricCipherKeyPair = keyPairGenerator.generateKeyPair();
//
////私钥，16进制格式，自己保存，格式如5d3ac703b9c287372c08a63a77b7cfbc3bd22095e366fd72e47c1e35ea2f20ef
//        BigInteger privatekey = ((ECPrivateKeyParameters) asymmetricCipherKeyPair.getPrivate()).getD();
//        String privateKeyHex = privatekey.toString(16);
//        System.out.println("privateKeyHex:"+privateKeyHex);
////公钥，16进制格式，发给前端，格式如 041f21ac91ada7fe88123499cc2fb81b51fa9be7c9655e78d327bd4985b0ab2cb939fda7ce39f3725f4ce564dc34fa6f005b9c1f7c784d4b40c1216ea45ce4f610
//        ECPoint ecPoint = ((ECPublicKeyParameters) asymmetricCipherKeyPair.getPublic()).getQ();
//
//        String publicKeyHex = Hex.toHexString(ecPoint.getEncoded(false));
////        String publicKeyHex = byteToHex(ecPoint.getEncoded(false));
//        System.out.println("publicKeyHex:"+publicKeyHex);
//
//    }
//    /**
//     * byte数组转hex
//     * @param bytes
//     * @return
//     */
//    public static String byteToHex(byte[] bytes){
//        String strHex = "";
//        StringBuilder sb = new StringBuilder("");
//        for (int n = 0; n < bytes.length; n++) {
//            strHex = Integer.toHexString(bytes[n] & 0xFF);
//            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
//        }
//        return sb.toString().trim();
//    }
//
//    public static void ttt() throws Exception {
//        X9ECParameters sm2ECParameters = GMNamedCurves.getByName("sm2p256v1");
//        ECDomainParameters domainParameters = new ECDomainParameters(sm2ECParameters.getCurve(), sm2ECParameters.getG(), sm2ECParameters.getN());
//        String cipherData = "041fb8ddd659dc47a61f57e808d4dae9859f5a17292c609fcaeb4b1d07623470db2919fdd0e0192c42c6eef19a1ac13a186ffd5878660decc6349f74d2cad840bc2d644f41deeeceeaf93f806690ce1bf0c6637cf6b34d3c423b63f2a52804be3cec5a4c2646039e09da293af5";
//        byte[] cipherDataByte = Hex.decode(cipherData);
//
////刚才的私钥Hex，先还原私钥
//        String privateKey = "a2081b5b81fbea0b6b973a3ab6dbbbc65b1164488bf22d8ae2ff0b8260f64853";
//        BigInteger privateKeyD = new BigInteger(privateKey, 16);
//        ECPrivateKeyParameters privateKeyParameters = new ECPrivateKeyParameters(privateKeyD, domainParameters);
//
////用私钥解密
//        SM2Engine sm2Engine = new SM2Engine();
//        sm2Engine.init(false, privateKeyParameters);
////processBlock得到Base64格式，记得解码
//        byte[] arrayOfBytes = Base64.getDecoder().decode(sm2Engine.processBlock(cipherDataByte, 0, cipherDataByte.length));
//
////得到明文：SM2 Encryption Test
//        String data = new String(arrayOfBytes);
//        System.out.println(data);
//    }
//
//    public static void main(String[] args) throws Exception {
////        pripub();
//        ttt();
//    }
//}
