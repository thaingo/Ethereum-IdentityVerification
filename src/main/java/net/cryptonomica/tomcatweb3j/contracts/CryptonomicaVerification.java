package net.cryptonomica.tomcatweb3j.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes20;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple9;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class CryptonomicaVerification extends Contract {
    private static final String BINARY = "6060604052608060405190810160405280604c81526020017f492068657265627920636f6e6669726d2074686174207468652061646472657381526020017f73203c61646472657373206c6f776572636173653e206973206d79204574686581526020017f7265756d20616464726573730000000000000000000000000000000000000000815250600c9080516200009c92916020019062000103565b506011805460a060020a60ff02191690553415620000b957600080fd5b600e8054600160a060020a033316600160a060020a031991821681179092556000828152600f60205260409020805460ff19166001179055601180549091169091179055620001a8565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200014657805160ff191683800117855562000176565b8280016001018555821562000176579182015b828111156200017657825182559160200191906001019062000159565b506200018492915062000188565b5090565b620001a591905b808211156200018457600081556001016200018f565b90565b611a4080620001b86000396000f3006060604052600436106101955763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166302c29349811461019a57806309905bdb146101cd5780630dc2968c146101f257806321b8092e1461028857806322652e05146102a95780632d06177a146102c857806339b51e7c146102e757806345d6f02e1461030657806347889c4214610325578063546e1959146103445780635b3d0bc11461036357806361b027b01461038257806365455fdc146103c3578063735dca66146103e257806376e57d4b14610528578063836afead1461053b5780638da5cb5b1461055a5780639201de551461058957806392b4e1321461059f5780639538833c1461085a5780639a159bf61461086d578063ac18de431461088c578063b17a98b6146108ab578063c6688445146108be578063cfb51928146108d1578063d008a10b14610922578063d6e87b44146109be578063e998d2fa146109e3578063ec94526914610a02578063f2bcd02214610a21578063f3ae241514610a34578063fb20dc8014610a53575b600080fd5b34156101a557600080fd5b6101b9600160a060020a0360043516610a69565b604051901515815260200160405180910390f35b34156101d857600080fd5b6101e0610b35565b60405190815260200160405180910390f35b34156101fd57600080fd5b610211600160a060020a0360043516610b3b565b60405160208082528190810183818151815260200191508051906020019080838360005b8381101561024d578082015183820152602001610235565b50505050905090810190601f16801561027a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561029357600080fd5b6102a7600160a060020a0360043516610beb565b005b34156102b457600080fd5b610211600160a060020a0360043516610c8c565b34156102d357600080fd5b6102a7600160a060020a0360043516610d09565b34156102f257600080fd5b6101e0600160a060020a0360043516610d7d565b341561031157600080fd5b6101e0600160a060020a0360043516610d8f565b341561033057600080fd5b6101e0600160a060020a0360043516610da1565b341561034f57600080fd5b6102a7600160a060020a0360043516610db3565b341561036e57600080fd5b6101e0600160a060020a0360043516610e2c565b341561038d57600080fd5b6103a1600160a060020a0360043516610e3e565b6040516bffffffffffffffffffffffff19909116815260200160405180910390f35b34156103ce57600080fd5b6101e0600160a060020a0360043516610e5f565b34156103ed57600080fd5b6102a760048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094966bffffffffffffffffffffffff19873516966020808201359750919550606081019450604090810135860180830194503592508291601f83018190048102019051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001909190803590602001908201803590602001908080601f016020809104026020016040519081016040528181529291906020840183838082843750949650610e7195505050505050565b341561053357600080fd5b6101b9611144565b341561054657600080fd5b6101e0600160a060020a0360043516611154565b341561056557600080fd5b61056d611166565b604051600160a060020a03909116815260200160405180910390f35b341561059457600080fd5b610211600435611175565b34156105aa57600080fd5b6105be600160a060020a0360043516611231565b60405180806020018a81526020018060200180602001898152602001806020018881526020018781526020018060200186810386528f81815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561066f5780601f106106445761010080835404028352916020019161066f565b820191906000526020600020905b81548152906001019060200180831161065257829003601f168201915b505086810385528d54600260001961010060018416150201909116048082526020909101908e9080156106e35780601f106106b8576101008083540402835291602001916106e3565b820191906000526020600020905b8154815290600101906020018083116106c657829003601f168201915b505086810384528c54600260001961010060018416150201909116048082526020909101908d9080156107575780601f1061072c57610100808354040283529160200191610757565b820191906000526020600020905b81548152906001019060200180831161073a57829003601f168201915b505086810383528a54600260001961010060018416150201909116048082526020909101908b9080156107cb5780601f106107a0576101008083540402835291602001916107cb565b820191906000526020600020905b8154815290600101906020018083116107ae57829003601f168201915b505086810382528754600260001961010060018416150201909116048082526020909101908890801561083f5780601f106108145761010080835404028352916020019161083f565b820191906000526020600020905b81548152906001019060200180831161082257829003601f168201915b50509e50505050505050505050505050505060405180910390f35b341561086557600080fd5b6102a761126c565b341561087857600080fd5b6101e0600160a060020a03600435166112f7565b341561089757600080fd5b6102a7600160a060020a0360043516611309565b34156108b657600080fd5b6101b961137a565b34156108c957600080fd5b610211611461565b34156108dc57600080fd5b6101e060046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506114cc95505050505050565b6102a760046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094966bffffffffffffffffffffffff19873516969095506040808201955060209182013587018083019550359350839250601f83018290048202909101905190810160405281815292919060208401838380828437509496506114d995505050505050565b34156109c957600080fd5b61056d6bffffffffffffffffffffffff19600435166116ff565b34156109ee57600080fd5b6102a7600160a060020a036004351661171a565b3415610a0d57600080fd5b6101e0600160a060020a0360043516611848565b3415610a2c57600080fd5b61056d61185a565b3415610a3f57600080fd5b6101b9600160a060020a0360043516611869565b3415610a5e57600080fd5b6102a760043561187e565b600e5460009033600160a060020a03908116911614610a8757600080fd5b601154600160a060020a03838116911614610aa157600080fd5b60115460a060020a900460ff1615610ab857600080fd5b6011805474ff0000000000000000000000000000000000000000191660a060020a17908190557fff51cf04e7fbddffc521b8673e9282b10a91c659c12eea9ef99182bd9a95ff7190600160a060020a031633604051600160a060020a039283168152911660208201526040908101905180910390a1506001919050565b60105481565b60016020528060005260406000206000915090508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610be35780601f10610bb857610100808354040283529160200191610be3565b820191906000526020600020905b815481529060010190602001808311610bc657829003601f168201915b505050505081565b600e5433600160a060020a03908116911614610c0657600080fd5b60115460a060020a900460ff1615610c1d57600080fd5b601154600160a060020a033381169183821691167f15fc95cfd5d20b9661cf80c2719d8e3180bee6d89379a03b7b14ca6ac6adea9860405160405180910390a46011805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60096020528060005260406000206000915090508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610be35780601f10610bb857610100808354040283529160200191610be3565b600e5433600160a060020a03908116911614610d2457600080fd5b600160a060020a038082166000818152600f602052604090819020805460ff1916600117905533909216917f05a4006f300442cf8b7fdb885f5ee958812020bffb5c5a8e655fde64e5f987ed905160405180910390a350565b60076020526000908152604090205481565b600a6020526000908152604090205481565b60056020526000908152604090205481565b600e5433600160a060020a03908116911614610dce57600080fd5b6012805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a038381169182179092559033167f856621e76473127fb731503843c14f7b85c6c36fc405c3ea121471425f54fd7960405160405180910390a350565b60026020526000908152604090205481565b6000602081905290815260409020546c010000000000000000000000000281565b60046020526000908152604090205481565b600160a060020a0333166000908152600f602052604090205460ff161515610e9857600080fd5b600160a060020a0388166000908152600a60205260409020541515610ebc57600080fd5b600160a060020a03881660009081526007602052604090205415610edf57600080fd5b600160a060020a0388166000908152600d60205260409020878051610f089291602001906118f6565b50600160a060020a03881660008181526020818152604080832080546c010000000000000000000000008c0473ffffffffffffffffffffffffffffffffffffffff19918216179091556bffffffffffffffffffffffff198b168452600b83528184208054909116851790559282526002808252838320899055600d9091529190206001810187905501848051610fa29291602001906118f6565b50610fac846114cc565b600160a060020a038916600090815260036020818152604080842094909455600d905291902001838051610fe49291602001906118f6565b50610fee836114cc565b600160a060020a0389166000908152600460208181526040808420949094556005808252848420879055600d90915292909120908101849055018180516110399291602001906118f6565b50611043816114cc565b600160a060020a038916600081815260066020818152604080842095909555600781528483204290819055600d909152918490209081019190915590917f2014ad745d5cc240a4565583f1c0cf348b91f892966a154d418c591911ea04bf9190339051600160a060020a03821660208201526040808252835460026000196101006001841615020190911604908201819052819060608201908590801561112b5780601f106111005761010080835404028352916020019161112b565b820191906000526020600020905b81548152906001019060200180831161110e57829003601f168201915b5050935050505060405180910390a25050505050505050565b60115460a060020a900460ff1681565b60086020526000908152604090205481565b600e54600160a060020a031681565b61117d611970565b611185611970565b600060206040518059106111965750595b818152601f19601f8301168101602001604052905091505b602081101561122a578381602081106111c357fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000028282815181106111f257fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053506001016111ae565b5092915050565b600d60205260009081526040902060018101546004820154600683015460078401546002850192600386019290916005870191906008880189565b60125433600160a060020a0390811691161461128757600080fd5b601254600e54600160a060020a0391821691167fb532073b38c83145e3e5135377a08bf9aab55bc0fd7c1179cd4fb995d2a5159c60405160405180910390a3601254600e805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03909216919091179055565b60036020526000908152604090205481565b600e5433600160a060020a0390811691161461132457600080fd5b600160a060020a038082166000818152600f602052604090819020805460ff1916905533909216917f3e902a6ee93dd5b2d48bd1009c7701a481be512b1ef73dbed2f95ea44c59ea88905160405180910390a350565b601154600090600160a060020a03308116803192909116903180156108fc0290604051600060405180830381858888f19350505050151561140b57601154600160a060020a0333811691167f78746de4b42c369479b14075849ee3378535cb810d96e74712e26a7924f7b021836000604051918252151560208201526040908101905180910390a36000915061145d565b601154600160a060020a0333811691167f78746de4b42c369479b14075849ee3378535cb810d96e74712e26a7924f7b021836001604051918252151560208201526040908101905180910390a3600191505b5090565b600c8054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610be35780601f10610bb857610100808354040283529160200191610be3565b6000602082015192915050565b6010543410156114e857600080fd5b600160a060020a0333166000908152600a60205260409020541561150b57600080fd5b825160281461151957600080fd5b6bffffffffffffffffffffffff1982166000908152600b6020526040902054600160a060020a03161561154b57600080fd5b600160a060020a03331660009081526001602052604090208380516115749291602001906118f6565b50600160a060020a0333166000908152600d602052604090206008018180516115a19291602001906118f6565b600160a060020a033316600090815260096020526040902081546115d8929060026000196101006001841615020190911604611982565b50600160a060020a0333166000818152600a6020526040908190204290557f3c21c5143ac760b44e24852cca9d3858a3487646fe0fa6c591aa3199cc65531a908590849051808060200180602001838103835285818151815260200191508051906020019080838360005b8381101561165b578082015183820152602001611643565b50505050905090810190601f1680156116885780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156116be5780820151838201526020016116a6565b50505050905090810190601f1680156116eb5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a2505050565b600b60205260009081526040902054600160a060020a031681565b80600160a060020a031633600160a060020a031614806117525750600160a060020a0333166000908152600f602052604090205460ff165b151561175d57600080fd5b600160a060020a0380821660008181526008602090815260408083204290819055600d909252918290206007810182905533909416937fc6f2b8565550ea0e6941e2f0f6b7e65e5eb1fdccb33e0c7815af0f3ce5669cff929091905160208101829052604080825283546002600019610100600184161502019091160490820181905281906060820190859080156118365780601f1061180b57610100808354040283529160200191611836565b820191906000526020600020905b81548152906001019060200180831161181957829003601f168201915b5050935050505060405180910390a350565b60066020526000908152604090205481565b601154600160a060020a031681565b600f6020526000908152604090205460ff1681565b600160a060020a0333166000908152600f602052604081205460ff1615156118a557600080fd5b506010805490829055600160a060020a0333167f665d155f71ad96c4a04629d54ef9fb27ef57911253588f2ee93474cd02fa3f53828460405191825260208201526040908101905180910390a25050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061193757805160ff1916838001178555611964565b82800160010185558215611964579182015b82811115611964578251825591602001919060010190611949565b5061145d9291506119f7565b60206040519081016040526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106119bb5780548555611964565b8280016001018555821561196457600052602060002091601f016020900482015b828111156119645782548255916001019190600101906119dc565b611a1191905b8082111561145d57600081556001016119fd565b905600a165627a7a723058205d883535e3010c345f71e8432366745740f31a379d0340e8801b497f4fee1aa90029";

    protected CryptonomicaVerification(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CryptonomicaVerification(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<SignedStringUploadedEventResponse> getSignedStringUploadedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SignedStringUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<SignedStringUploadedEventResponse> responses = new ArrayList<SignedStringUploadedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            SignedStringUploadedEventResponse typedResponse = new SignedStringUploadedEventResponse();
            typedResponse.fromAccount = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.fingerprint = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.uploadedString = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SignedStringUploadedEventResponse> signedStringUploadedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("SignedStringUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SignedStringUploadedEventResponse>() {
            @Override
            public SignedStringUploadedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SignedStringUploadedEventResponse typedResponse = new SignedStringUploadedEventResponse();
                typedResponse.fromAccount = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.fingerprint = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.uploadedString = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<VerificationAddedEventResponse> getVerificationAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("VerificationAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<VerificationAddedEventResponse> responses = new ArrayList<VerificationAddedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            VerificationAddedEventResponse typedResponse = new VerificationAddedEventResponse();
            typedResponse.verifiedAccount = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.forFingerprint = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.verificationAddedByAccount = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<VerificationAddedEventResponse> verificationAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("VerificationAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, VerificationAddedEventResponse>() {
            @Override
            public VerificationAddedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                VerificationAddedEventResponse typedResponse = new VerificationAddedEventResponse();
                typedResponse.verifiedAccount = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.forFingerprint = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.verificationAddedByAccount = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<VerificationRevokedEventResponse> getVerificationRevokedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("VerificationRevoked", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<VerificationRevokedEventResponse> responses = new ArrayList<VerificationRevokedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            VerificationRevokedEventResponse typedResponse = new VerificationRevokedEventResponse();
            typedResponse.revocedforAccount = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.revokedBy = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.withFingerprint = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.revokedOnUnixTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<VerificationRevokedEventResponse> verificationRevokedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("VerificationRevoked", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, VerificationRevokedEventResponse>() {
            @Override
            public VerificationRevokedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                VerificationRevokedEventResponse typedResponse = new VerificationRevokedEventResponse();
                typedResponse.revocedforAccount = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.revokedBy = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.withFingerprint = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.revokedOnUnixTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<ChangeOwnerStartedEventResponse> getChangeOwnerStartedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ChangeOwnerStarted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ChangeOwnerStartedEventResponse> responses = new ArrayList<ChangeOwnerStartedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ChangeOwnerStartedEventResponse typedResponse = new ChangeOwnerStartedEventResponse();
            typedResponse.startedBy = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ChangeOwnerStartedEventResponse> changeOwnerStartedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ChangeOwnerStarted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ChangeOwnerStartedEventResponse>() {
            @Override
            public ChangeOwnerStartedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ChangeOwnerStartedEventResponse typedResponse = new ChangeOwnerStartedEventResponse();
                typedResponse.startedBy = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<OwnerChangedEventResponse> getOwnerChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnerChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnerChangedEventResponse> responses = new ArrayList<OwnerChangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnerChangedEventResponse typedResponse = new OwnerChangedEventResponse();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnerChangedEventResponse> ownerChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnerChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnerChangedEventResponse>() {
            @Override
            public OwnerChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnerChangedEventResponse typedResponse = new OwnerChangedEventResponse();
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<ManagerAddedEventResponse> getManagerAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ManagerAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ManagerAddedEventResponse> responses = new ArrayList<ManagerAddedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ManagerAddedEventResponse typedResponse = new ManagerAddedEventResponse();
            typedResponse.added = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.addedBy = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ManagerAddedEventResponse> managerAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ManagerAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ManagerAddedEventResponse>() {
            @Override
            public ManagerAddedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ManagerAddedEventResponse typedResponse = new ManagerAddedEventResponse();
                typedResponse.added = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.addedBy = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<ManagerRemovedEventResponse> getManagerRemovedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ManagerRemoved", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ManagerRemovedEventResponse> responses = new ArrayList<ManagerRemovedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ManagerRemovedEventResponse typedResponse = new ManagerRemovedEventResponse();
            typedResponse.removed = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.removedBy = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ManagerRemovedEventResponse> managerRemovedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ManagerRemoved", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ManagerRemovedEventResponse>() {
            @Override
            public ManagerRemovedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ManagerRemovedEventResponse typedResponse = new ManagerRemovedEventResponse();
                typedResponse.removed = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.removedBy = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<PriceChangedEventResponse> getPriceChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("PriceChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PriceChangedEventResponse> responses = new ArrayList<PriceChangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PriceChangedEventResponse typedResponse = new PriceChangedEventResponse();
            typedResponse.changedBy = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.from = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.to = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PriceChangedEventResponse> priceChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("PriceChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PriceChangedEventResponse>() {
            @Override
            public PriceChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PriceChangedEventResponse typedResponse = new PriceChangedEventResponse();
                typedResponse.changedBy = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.from = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.to = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<WithdrawalEventResponse> getWithdrawalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Withdrawal", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<WithdrawalEventResponse> responses = new ArrayList<WithdrawalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            WithdrawalEventResponse typedResponse = new WithdrawalEventResponse();
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.by = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sumInWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.success = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WithdrawalEventResponse> withdrawalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Withdrawal", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, WithdrawalEventResponse>() {
            @Override
            public WithdrawalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                WithdrawalEventResponse typedResponse = new WithdrawalEventResponse();
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.by = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sumInWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.success = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<WithdrawalAddressChangedEventResponse> getWithdrawalAddressChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("WithdrawalAddressChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<WithdrawalAddressChangedEventResponse> responses = new ArrayList<WithdrawalAddressChangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            WithdrawalAddressChangedEventResponse typedResponse = new WithdrawalAddressChangedEventResponse();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.changedBy = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WithdrawalAddressChangedEventResponse> withdrawalAddressChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("WithdrawalAddressChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, WithdrawalAddressChangedEventResponse>() {
            @Override
            public WithdrawalAddressChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                WithdrawalAddressChangedEventResponse typedResponse = new WithdrawalAddressChangedEventResponse();
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.changedBy = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<WithdrawalAddressFixedEventResponse> getWithdrawalAddressFixedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("WithdrawalAddressFixed", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<WithdrawalAddressFixedEventResponse> responses = new ArrayList<WithdrawalAddressFixedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            WithdrawalAddressFixedEventResponse typedResponse = new WithdrawalAddressFixedEventResponse();
            typedResponse.withdrawalAddressFixedAs = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.fixedBy = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WithdrawalAddressFixedEventResponse> withdrawalAddressFixedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("WithdrawalAddressFixed", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, WithdrawalAddressFixedEventResponse>() {
            @Override
            public WithdrawalAddressFixedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                WithdrawalAddressFixedEventResponse typedResponse = new WithdrawalAddressFixedEventResponse();
                typedResponse.withdrawalAddressFixedAs = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.fixedBy = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> fixWithdrawalAddress(String _withdrawalAddress) {
        Function function = new Function(
                "fixWithdrawalAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_withdrawalAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> priceForVerificationInWei() {
        Function function = new Function("priceForVerificationInWei", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> unverifiedFingerprint(String param0) {
        Function function = new Function("unverifiedFingerprint", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setWithdrawalAddress(String _withdrawalAddress) {
        Function function = new Function(
                "setWithdrawalAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_withdrawalAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> signedString(String param0) {
        Function function = new Function("signedString", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addManager(String _acc) {
        Function function = new Function(
                "addManager", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> verificationAddedOn(String param0) {
        Function function = new Function("verificationAddedOn", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> signedStringUploadedOnUnixTime(String param0) {
        Function function = new Function("signedStringUploadedOnUnixTime", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> birthDate(String param0) {
        Function function = new Function("birthDate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> changeOwnerStart(String _newOwner) {
        Function function = new Function(
                "changeOwnerStart", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> keyCertificateValidUntil(String param0) {
        Function function = new Function("keyCertificateValidUntil", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> fingerprint(String param0) {
        Function function = new Function("fingerprint", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes20>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> lastName(String param0) {
        Function function = new Function("lastName", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> addVerificationData(String _acc, String _fingerprint, byte[] _fingerprintBytes20, BigInteger _keyCertificateValidUntil, String _firstName, String _lastName, BigInteger _birthDate, String _nationality) {
        Function function = new Function(
                "addVerificationData", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acc), 
                new org.web3j.abi.datatypes.Utf8String(_fingerprint), 
                new org.web3j.abi.datatypes.generated.Bytes20(_fingerprintBytes20), 
                new org.web3j.abi.datatypes.generated.Uint256(_keyCertificateValidUntil), 
                new org.web3j.abi.datatypes.Utf8String(_firstName), 
                new org.web3j.abi.datatypes.Utf8String(_lastName), 
                new org.web3j.abi.datatypes.generated.Uint256(_birthDate), 
                new org.web3j.abi.datatypes.Utf8String(_nationality)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> withdrawalAddressFixed() {
        Function function = new Function("withdrawalAddressFixed", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> revokedOn(String param0) {
        Function function = new Function("revokedOn", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> bytes32ToString(byte[] _bytes32) {
        Function function = new Function("bytes32ToString", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bytes32)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple9<String, BigInteger, String, String, BigInteger, String, BigInteger, BigInteger, String>> verification(String param0) {
        final Function function = new Function("verification", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple9<String, BigInteger, String, String, BigInteger, String, BigInteger, BigInteger, String>>(
                new Callable<Tuple9<String, BigInteger, String, String, BigInteger, String, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple9<String, BigInteger, String, String, BigInteger, String, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple9<String, BigInteger, String, String, BigInteger, String, BigInteger, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (String) results.get(8).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> changeOwnerAccept() {
        Function function = new Function(
                "changeOwnerAccept", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> firstName(String param0) {
        Function function = new Function("firstName", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> removeManager(String manager) {
        Function function = new Function(
                "removeManager", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(manager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawAllToWithdrawalAddress() {
        Function function = new Function(
                "withdrawAllToWithdrawalAddress", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> stringToSignExample() {
        Function function = new Function("stringToSignExample", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> stringToBytes32(String source) {
        Function function = new Function("stringToBytes32", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(source)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> uploadSignedString(String _fingerprint, byte[] _fingerprintBytes20, String _signedString, BigInteger weiValue) {
        Function function = new Function(
                "uploadSignedString", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_fingerprint), 
                new org.web3j.abi.datatypes.generated.Bytes20(_fingerprintBytes20), 
                new org.web3j.abi.datatypes.Utf8String(_signedString)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<String> addressAttached(byte[] param0) {
        Function function = new Function("addressAttached", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes20(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> revokeVerification(String _acc) {
        Function function = new Function(
                "revokeVerification", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> nationality(String param0) {
        Function function = new Function("nationality", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> withdrawalAddress() {
        Function function = new Function("withdrawalAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isManager(String param0) {
        Function function = new Function("isManager", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setPriceForVerification(BigInteger priceInWei) {
        Function function = new Function(
                "setPriceForVerification", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(priceInWei)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<CryptonomicaVerification> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CryptonomicaVerification.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CryptonomicaVerification> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CryptonomicaVerification.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static CryptonomicaVerification load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CryptonomicaVerification(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static CryptonomicaVerification load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CryptonomicaVerification(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class SignedStringUploadedEventResponse {
        public String fromAccount;

        public String fingerprint;

        public String uploadedString;
    }

    public static class VerificationAddedEventResponse {
        public String verifiedAccount;

        public String forFingerprint;

        public String verificationAddedByAccount;
    }

    public static class VerificationRevokedEventResponse {
        public String revocedforAccount;

        public String revokedBy;

        public String withFingerprint;

        public BigInteger revokedOnUnixTime;
    }

    public static class ChangeOwnerStartedEventResponse {
        public String startedBy;

        public String newOwner;
    }

    public static class OwnerChangedEventResponse {
        public String from;

        public String to;
    }

    public static class ManagerAddedEventResponse {
        public String added;

        public String addedBy;
    }

    public static class ManagerRemovedEventResponse {
        public String removed;

        public String removedBy;
    }

    public static class PriceChangedEventResponse {
        public String changedBy;

        public BigInteger from;

        public BigInteger to;
    }

    public static class WithdrawalEventResponse {
        public String to;

        public String by;

        public BigInteger sumInWei;

        public Boolean success;
    }

    public static class WithdrawalAddressChangedEventResponse {
        public String from;

        public String to;

        public String changedBy;
    }

    public static class WithdrawalAddressFixedEventResponse {
        public String withdrawalAddressFixedAs;

        public String fixedBy;
    }
}
