package sharma.pankaj.cryptocoininfo;

/*
 *   pankaj sharma
 */
public class IconChecker {

    int iconLocation, defl;
   public String getIconCurrency(String iconname) {
       Integer[] imgid={
               R.drawable.bitcoin,
               R.drawable.ethereum,
               R.drawable.rippel,
               R.drawable.btc_cash,
               R.drawable.litecoin,
               R.drawable.cardano,
               R.drawable.neo,
               R.drawable.stellar,
               R.drawable.eos,
               R.drawable.iota,
               R.drawable.dash,
               R.drawable.nem,
               R.drawable.monero,
               R.drawable.litecoin,
               R.drawable.tron,
               R.drawable.ethereumclassic,
               R.drawable.vechain,
               R.drawable.qtum,
               R.drawable.bitcoingold,
               R.drawable.tron,
               R.drawable.iconicx,  /* not conform */
               R.drawable.omisego,
               R.drawable.zcash,
               R.drawable.raiblock,  /* RAIBLOCKS  check icon */
               R.drawable.verge,
               R.drawable.binancecoin,
               R.drawable.steem,
               R.drawable.populous,
               R.drawable.bytecoin,
               R.drawable.siacoin,
               R.drawable.stratis,
               R.drawable.rchain,
               R.drawable.status,
               R.drawable.dogecoin,
               R.drawable.waves,
               R.drawable.bitshares,
               R.drawable.maker,
               R.drawable.waltonchain,
               R.drawable.ox,
               R.drawable.ucash,  /* UCASH  check icon */
               R.drawable.decred,
               R.drawable.aeternity,
               R.drawable.augur,
               R.drawable.veritaseum,
               R.drawable.hshare,  /* HSHARE  check icon */
               R.drawable.komodo,
               R.drawable.zclassic,
               R.drawable.electroneum,
               R.drawable.komodo,  /* KUCOIN-SHARES */
               R.drawable.ardor,
               R.drawable.digibyte,
               R.drawable.revain,
               R.drawable.ark,
               R.drawable.digixdao,
               R.drawable.dragonchain,
               R.drawable.gas,
               R.drawable.basic,  /* BASIC-ATTENTION-TOKEN  check icon */
               R.drawable.byteballbytes,
               R.drawable.zilliqa,
               R.drawable.loopring,
               R.drawable.golem,  /* GOLEM-NETWORK-TOKENS */
               R.drawable.bytom,
               R.drawable.kybernetwork,
               R.drawable.monacoin,
               R.drawable.syscoin,
               R.drawable.pivx,
               R.drawable.aelf,
               R.drawable.qash, /* not icon QASH */
               R.drawable.cryptonex,
               R.drawable.dentacoin,
               R.drawable.aion,
               R.drawable.bitcore,
               R.drawable.nebulas,
               R.drawable.iostoken,
               R.drawable.ethos,
               R.drawable.factom,
               R.drawable.powerledger,
               R.drawable.gxshares,
               R.drawable.pillar,
               R.drawable.salt,
               R.drawable.funfair,
               R.drawable.dent,
               R.drawable.kin,
               R.drawable.cindicator,
               R.drawable.nxt,
               R.drawable.zcoin,
               R.drawable.enigma,
               R.drawable.polymath,
               R.drawable.chainlink,
               R.drawable.reddcoin,
               R.drawable.neblio,
               R.drawable.maidsafecoin,  /* MAIDSAFECOIN  check icon */
               R.drawable.requestnetwork,
               R.drawable.particl,
               R.drawable.bancor,
               R.drawable.quantstamp,
               R.drawable.tenx,
               R.drawable.imgtest,  /* WAX  check icon */
               R.drawable.smartcash,
               R.drawable.blocknet,
               R.drawable.imgtest,
       };
       switch (iconname) {
           case "BITCOIN":
               iconLocation = imgid[0];
               break;
           case "ETHEREUM":
               iconLocation = imgid[1];
               break;
           case "RIPPLE":
               iconLocation = imgid[2];
               break;
           case "BITCOIN-CASH":
               iconLocation = imgid[3];
               break;
           case "LITECOIN":
               iconLocation = imgid[4];
               break;
           case "CARDANO":
               iconLocation = imgid[5];
               break;
           case "NEO":
               iconLocation = imgid[6];
               break;
           case "STELLAR":
               iconLocation = imgid[7];
               break;
           case "EOS":
               iconLocation = imgid[8];
               break;
           case "IOTA":
               iconLocation = imgid[9];
               break;
           case "DASH":
               iconLocation = imgid[10];
               break;
           case "NEM":
               iconLocation = imgid[11];
               break;
           case "MONERO":
               iconLocation = imgid[12];
               break;
           case "LISK":
               iconLocation = imgid[13];
               break;
           case "TRON":
               iconLocation = imgid[14];
               break;
           case "ETHEREUM-CLASSIC":
               iconLocation = imgid[15];
               break;
           case "VECHAIN":
               iconLocation = imgid[16];
               break;
           case "QTUM":
               iconLocation = imgid[17];
               break;
           case "BITCOIN-GOLD":
               iconLocation = imgid[18];
               break;
           case "TETHER":
               iconLocation = imgid[19];
               break;
           case "ICON":
               iconLocation = imgid[20];
               break;

           case "OMISEGO":
               iconLocation = imgid[21];
               break;
           case "ZCASH":
               iconLocation = imgid[22];
               break;
           case "RAIBLOCKS":
               iconLocation = imgid[23];
               break;
           case "VERGE":
               iconLocation = imgid[24];
               break;
           case "BINANCE-COIN":
               iconLocation = imgid[25];
               break;
           case "STEEM":
               iconLocation = imgid[26];
               break;
           case "POPULOUS":
               iconLocation = imgid[27];
               break;
           case "BYTECOIN-BCN":
               iconLocation = imgid[28];
               break;
           case "SIACOIN":
               iconLocation = imgid[29];
               break;
           case "STRATIS":
               iconLocation = imgid[30];
               break;

           case "RCHAIN":
               iconLocation = imgid[31];
               break;
           case "STATUS":
               iconLocation = imgid[32];
               break;
           case "DOGECOIN":
               iconLocation = imgid[33];
               break;
           case "WAVES":
               iconLocation = imgid[34];
               break;
           case "BITSHARES":
               iconLocation = imgid[35];
               break;
           case "MAKER":
               iconLocation = imgid[36];
               break;
           case "WALTON":
               iconLocation = imgid[37];
               break;
           case "0X":
               iconLocation = imgid[38];
               break;
           case "UCASH":
               iconLocation = imgid[39];
               break;
           case "DECRED":
               iconLocation = imgid[40];
               break;

           case "AETERNITY":
               iconLocation = imgid[41];
               break;
           case "AUGUR":
               iconLocation = imgid[42];
               break;
           case "VERITASEUM":
               iconLocation = imgid[43];
               break;
           case "HSHARE":
               iconLocation = imgid[44];
               break;
           case "KOMODO":
               iconLocation = imgid[45];
               break;
           case "ZCLASSIC":
               iconLocation = imgid[46];
               break;
           case "ELECTRONEUM":
               iconLocation = imgid[47];
               break;
           case "KUCOIN-SHARES":
               iconLocation = imgid[48];
               break;
           case "ARDOR":
               iconLocation = imgid[49];
               break;
           case "DIGIBYTE":
               iconLocation = imgid[50];
               break;


           case "REVAIN":
               iconLocation = imgid[51];
               break;
           case "ARK":
               iconLocation = imgid[52];
               break;
           case "DIGIXDAO":
               iconLocation = imgid[53];
               break;
           case "DRAGONCHAIN":
               iconLocation = imgid[54];
               break;
           case "GAS":
               iconLocation = imgid[55];
               break;
           case "BASIC-ATTENTION-TOKEN":
               iconLocation = imgid[56];
               break;
           case "BYTEBALL":
               iconLocation = imgid[57];
               break;
           case "ZILLIQA":
               iconLocation = imgid[58];
               break;
           case "LOOPRING":
               iconLocation = imgid[59];
               break;
           case "GOLEM-NETWORK-TOKENS":
               iconLocation = imgid[60];
               break;


           case "BYTOM":
               iconLocation = imgid[61];
               break;
           case "KYBER-NETWORK":
               iconLocation = imgid[62];
               break;
           case "MONACOIN":
               iconLocation = imgid[63];
               break;
           case "SYSCOIN":
               iconLocation = imgid[64];
               break;
           case "PIVX":
               iconLocation = imgid[65];
               break;
           case "AELF":
               iconLocation = imgid[66];
               break;
           case "QASH":
               iconLocation = imgid[67];
               break;
           case "CRYPTONEX":
               iconLocation = imgid[68];
               break;
           case "DENTACOIN":
               iconLocation = imgid[69];
               break;
           case "AION":
               iconLocation = imgid[70];
               break;

           case "BITCORE":
               iconLocation = imgid[71];
               break;
           case "NEBULAS-TOKEN":
               iconLocation = imgid[72];
               break;
           case "IOSTOKEN":
               iconLocation = imgid[73];
               break;
           case "ETHOS":
               iconLocation = imgid[74];
               break;
           case "FACTOM":
               iconLocation = imgid[75];
               break;
           case "POWER-LEDGER":
               iconLocation = imgid[76];
               break;
           case "GXSHARES":
               iconLocation = imgid[77];
               break;
           case "PILLAR":
               iconLocation = imgid[78];
               break;
           case "SALT":
               iconLocation = imgid[79];
               break;
           case "FUNFAIR":
               iconLocation = imgid[80];
               break;

           case "DENT":
               iconLocation = imgid[81];
               break;
           case "KIN":
               iconLocation = imgid[82];
               break;
           case "CINDICATOR":
               iconLocation = imgid[83];
               break;
           case "NXT":
               iconLocation = imgid[84];
               break;
           case "ZCOIN":
               iconLocation = imgid[85];
               break;
           case "ENIGMA-PROJECT":
               iconLocation = imgid[86];
               break;
           case "POLYMATH-NETWORK":
               iconLocation = imgid[87];
               break;
           case "CHAINLINK":
               iconLocation = imgid[88];
               break;
           case "REDDCOIN":
               iconLocation = imgid[89];
               break;
           case "NEBLIO":
               iconLocation = imgid[90];
               break;

           case "MAIDSAFECOIN":
               iconLocation = imgid[91];
               break;
           case "REQUEST-NETWORK":
               iconLocation = imgid[92];
               break;
           case "PARTICL":
               iconLocation = imgid[93];
               break;
           case "BANCOR":
               iconLocation = imgid[94];
               break;
           case "QUANTSTAMP":
               iconLocation = imgid[95];
               break;
           case "TENX":
               iconLocation = imgid[96];
               break;
           case "WAX":
               iconLocation = imgid[97];
               break;
           case "SMARTCASH":
               iconLocation = imgid[98];
               break;
           case "BLOCKNET":
               iconLocation = imgid[99];
               break;
           default:
           iconLocation = imgid[100];
       }
       return null;
   }
}
