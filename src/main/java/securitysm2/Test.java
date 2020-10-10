package securitysm2;


import securitysm2.sm2.KeyModel;
import securitysm2.sm2.SM2Cipher;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Test {

    private static String priKey = "03ace564b89ae0f2ebf11a7b227c5fd960bf4a04d5d3ceeb964cc87f257460b6";
    private static String pubKey = "04f2aaa7c70b5b77caddfe0d61991a0497c7a3f2408ad8ea100b3d91173b04def11e247471dcb0348a1daea9ddccaa30d0cb2822da13ec11810bc94c0ec078cf75";


    private static SM2Cipher sm2Cipher;

    static {
        sm2Cipher = new SM2Cipher(pubKey, priKey);
    }

    //生成公私钥对
    public static void getKeyPair() {
        KeyModel keyModel = SM2Cipher.generateKeyPair();
        System.out.println("私钥：" + keyModel.getPrivateKey());
        System.out.println("公钥：" + keyModel.getPublicKey());
    }

    //后端加密（加密串在后端解密）
    public static String encrypt(String data) {
        return sm2Cipher.encrypt2Hex(data);
    }

    //后端解密（解后端加密过的串）
    public static String decrypt(String data) {
        return new String(sm2Cipher.decrypt(data), StandardCharsets.UTF_8);
    }

    //后端加密（前端解密）
    public static String encryptForJavaScript(String data) {
        return sm2Cipher.encrypt2HexForJavascript(data);
    }

    //后端解密（前端加密）
    public static String decryptFromJavaScript(String data) {
        return sm2Cipher.decryptFromJavascript(data);
    }

    public static void main(String[] args) {
        //后端java加密,java解密   ok
//        String miwen = encrypt("asdasd");
//        System.out.println("密文：" + miwen);
//        String mingwen = decrypt(miwen);
//        System.out.println("解密后明文：" + mingwen);

        String[] ss = {
                "8cd92fffdacf347638d3392a92c12b7b69b0f984998107d9e47a51c467124f4caa44cb0af4ba6ab59f60103dd0f86ebd9729c2366bf00f99e2f4d1d372962e59289c07cc91ecf32d9822f3fd8ea0ec67de338dc59da59b7c852d50164795c74db7129d01ccd8c82ed19e9661b7926178902be073c5e6fade3463f8922eb51006",
                "3b142a9113d588fd482c68f9fc5897398db9d95ac7b9006f0e6dd0c500d6855676bb4d6c35c80658fd42718391254149bcff94e8fa0112c5ba512c16715a4e42b0cf9f6e9aa8ac44b100c2d6865678867d9bc5dff6c10a75568a611bccfb5ed7ef60dbba9027275db24ed57baff4d94fed0b12efb9c3aab0b2b82b9cc2bbbd3d",
                "7a818ac22e2cccd2d6665f41ad035c3f18d8553c43b395fae1785638f6fbdf3f3c081f57963f84df3a435531a457f46dafecd7fe367b2e9e8078e5d9840fb09ee9c8fe8f415b1dcfcc0b4241eaa3faa3f2a85b8df67b38431a2f3426a158195f9e8dfa59d14e2fcb0b387142c1370bca1bb54aea372f3ae8b68c9a39bafa9c15",
                "299059d5353d5e12831547b435fe7e1dbc8e39d31c1e3b5d11733dfaaf918910168b7be01818c0bad59ff3e69324c03d3d3344fdf2cc668f31a4551c635107a9029bcc845fdc48b8c8fe90daa14be0247d195cf839997106a64c70699b2c3169c32d73a81b888320030a634d1f9091f13cf7eed845e070b58d38ee0171d5aa61",
                "7c15970da9f0b8e2552ca06a184481bec098b95887b6cf54eddf5067e7a7deec32ad19221ca240859ff316769f01f491313f00cc9f227d9502470742f9af0a0e9ebc8efe2975bd746d54548a90cffdad4ae0ddeed37ad6ebb43b029cbcd996efb32356f9e2ab8c8e4da6832afd4b010c8b40165197e04c5ceb5797cd55a8c9fc",
                "37d6dc76c96f36ce992c6697a3102a1acd409cefe232e3787c3339b6fb5a4d7195d5b752a9b5b530fc13d0deb6e1a0b363da0b4fa56384c8c7f04d478d842b454044795ea51a4ded6ee7ecf38943dba4f3956493086d4b9bd28ebf26976c27387dc15372799702c1ca17ebbd43d7b6d2c5b5f03034d5a3cc561c1989d857c69c",
                "161ccd9cbd3a3ffddd1b6c6bda3b926c2f733668fa90cd600c0835bdd30fa635ddfed50f48d424bbcc7aaa4afc316293811bd42e6ac594d05303fc2f62a350e376e459749056e9d309adce27f403bf6bd102c553bff49749e7097ba9cb73647059ab4fd028bed0ec6c833203f86409d016fa2587bf2c00f0e27b5d5bf9f08c23",
                "4d96935926bdb0eb1292e3372d164c767e59e28c6cc1d0c65cfe7d9caefec81e84c52b0b6cda1b7077a47f4d300859c22f616039269746add02162545eafa3fe70e4c73d6867f2c43b9691a5ee515892d9673a1f26987df2aff488797e6c3afe3068f1d6d6fa4ce369a3331d7eaf833cfba8827f742e101a8f484cc82d839002",
                "5a2a173decc761706b6c8f91debdd39927784007028106f05ad12b3f777afe7b1b51154414fbcc75c8f1b49d75a21e733039ed7ac2b4d231ba674d15c77321ad8e3fdbc91a4bb2d3e5a88566d44129be8c46129b0b3fe43771d59b2978db0c0923fe6682d143d25c52de05c7f97cbac37fa557659b0da163689ee5b1255e9f5b",
                "5abc3e8abf9a4f2f169f8ba60a43edf50212c08ca01af839cb7bfffb0f0e17c0a66c8bad7261491534ce4429ead7735c3f5c95fcfafad9261bd68ab9e811a4deb67e90cbf8735cc01c36e446d767b7c96d09d6321da404c0e1ec86970449dcaebd8463566558b3e574719b2ba68237d87902db14a1e0d041ad980f42ca883639",
                "0a536e5721f5f5514eb90b8b9690d3cc2326a55d48c7accc3cd32234dba5941f6d8c46c3b55a8447cce59b1f142008ce66317b7444f63f1ace272f1bb0357cde99fef1009743f454e3365064d02e7ea3a6a6df7a5e5799da92a9f7ad6da5af9a7fc6f5ab013e5fa083f510636d9c0edc387a8386fe3079c5970e9a1429b4c0ce",
                "d08c042e7e7721550cc72624bebcf63b8fe9e2f7db07fceba54eff7aafc949b3909bd6c28d8d799808cd9cd12ac1c1e341ff298cd69e2b6af268cb5a486b2f101bc0c454b3ca96e7c62aed800a49c60e39b1d6a86990667b8cfc6b924a4368c66ca80d2b94911a164601ba2110cf6360b29cb08a5c483f117bab4e2e5b9dbc33",
                "efcc7e432c05e9704eccc7ce3ad1157d4a35abe8ab37dbdb598ccee8786055c07507274f2ac67d6ea25cf3c69ecf02a3b4c184700a108685eb13e761de28e10144b5e033f194a1b0906f78115acf95a9d86c63d10418fec4258d5fe740f03995abc61502f67ac6f0157a4d0f423d4c92334e737dd51d3168e43428c754447dae",
                "cdfc39933ba7c997ac7d7818cd39341b7a1a1c8895a06e70bd4dc67ca18bef301cae43ccfdaeb3423d15d1f94ab494efa07ae7eb1616749c0ac45acb7934a6fc72c0f87fc0111eb5f43f96eae48cb568f849c12b361b7dc7fd687a4193c9f5d2aacf7dfe3fd5738387601589c6ec002b63611837528b84935daa319bcaba770c",
                "dd3eadb5c18e1427eace3c1ba0e61bdee223bbf8d7a9c14af7816b9bbda8631aa8a29a7413c868145993a403c52f756d54627cea6e5b8f96ecfb63fc552f225f65263f3b6d4f132000bb1e05c9a8eee3c57d9aef39a48f81578afce470ca310f036076cf374d89cccfa7d63b71f644314cc13f372b471941a8b70dfe9e1ab516",
                "53880a61613e101595a840cfd57a2e94dbc32205c3041e1ed8e5c25b84275bb2f0bd868886b8798cf726dec40fbdd55c3b0cc1b15486c70a63cb68bc6eb348bf11e743e198ade7cf2b5eb3a5836e43d6ee55fdd60edac32cf5f39fc3994d324d68748fbd099fdee22a29c4c179355f037723c105ec4e2b9d5e7dcb654b75a371",
                "d90c5254b67bd782eca2d88297c524582556ea04391613e6041ba157e5bf2c91940ac274a27d50e43d61fb2bd32c0ca5928f248d967163ecfd08bd6ba468bdbb5e90d7ce8c1a8d801f6cb2c777962741f72b5c1f5c696a1068eb4c62ae165c8c517678f18f51a00fe4cce4990efa588ca4fd622b84376acb3812146cea6c1319",
                "085ca5533b29a253da65f0d39b77594beaf678127d63ee0f12167a5936c4003693255eb3246c1f53aa869dd5251cd1fe4110ea01c3635f551ce7d3656092b3660b808d8496de96e90ffa82674d3a3fba3598f0867be5f354db7eb8d4383a37386401fca5de86067a108e09eae338f0e1eecaca2fd1b76dc450f79b763fc43bdb",
                "032f7646ad4a9f0570ed5b659341ff7f1a60761ae383b94708de959d208657836acef6ce5e0777f1178d782a9872c19ced8ed5e096863505c36e4c4ac06fcb3eebe8b28a8267bb75f041d8d2dc173da47ed8da99dc5cf9211f122aeff622d8f926a3e8cdbc735de63ae14257f7b366d93308497b66af8f76fbb9ebb494fba37e",
                "d9c441edadae008555c5d5202c3a3f1a9f6678c32245ac9a6c85f6116b5b5cfcf4ddcbcbc1b9342d9f2280901924e3680dac431b8d1ead9deef9a5f5b4789c7e08277b293821882501245cdecbbae85fec946a53d3c3f91759382d9affdbd805ef059ee8ddbaa8b75d39db160191d44a440467249e9897e7af028bc2351020df"
        };
        for (String s1 : ss) {
            String s = decryptFromJavaScript(s1);
            byte[] decode = Base64.getDecoder().decode(s.getBytes());
            System.out.println(new String(decode, StandardCharsets.UTF_8));
        }
        //sample-sm2_crypt.html  js加密　　java解密
//        String s = decryptFromJavaScript("c0d4636db2c3f5c8b952c6e1e7043e57171bf556f620e012c731a95553e1e13d8e509d2bb249f0dbade704cf207fa5a70cc605c1a183aabc95a53600d7a1a8b56d3638dab0f044089557413984e14f350ff061088c06d9c86adff682533c9fca22965c7bcd8765d899666d46");
//        byte[] decode = Base64.getDecoder().decode(s.getBytes());
//        System.out.println(new String(decode, StandardCharsets.UTF_8));

        // java加密　js解密
//        String jgjasods = encryptForJavaScript("asdfasdfasdfadsf");
//        System.out.println(jgjasods);

//        getKeyPair();

        //后端加密传值到前端
//        System.out.println(encryptForJavaScript("abcdefghijklmnopq"));
//        String name = "304502201c1183a88f08b7d40db52f42552d1e2f3932c9f764b00b8cc4fe580e2c4438ef022100d1008a3a5202dd544b249baa3971ed16797eeeed15650460d80ccee115b683b3";
//        //String encrypted = encryptForJavaScript(name);
//        String decrypt = decryptFromJavaScript(name);
//        System.out.println("对前端加密数据进行解密解密：" + decrypt);


//        //SM3进行信息摘要
//        String a = "0ff66e023637c9e2bb214f5a22010db4780ce1d58d74655f12e90ce97b2a1393ae6bec3cdb7edff297e157ee0378cc666ff522da6be0b402c9c54c2c86cd334453cb94995ba1a6322edbe5a93bb381962d50c224cada01f8268c098d866603c216cb61a3d46e78d150f715c315c4e4c1ec";
//        SM3Cipher sm3 = new SM3Cipher();
//        System.out.println(ByteUtils.getHexString(sm3.encrypt(a)));
//
//


    }
}
