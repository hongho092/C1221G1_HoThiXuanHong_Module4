package com.example.service.contract.impl;

import com.example.model.contract.Contract;
import com.example.reposirory.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findList() {
        return contractRepository.findAll();
    }
}


//    @Override
//    public Page<Contract> findAll(Pageable pageable) {
//        Page<Contract> contractPage = contractRepository.findAll(pageable);
//        List<Contract> contractList = contractPage.getContent();
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//        for (int i=0; i < contractList.size(); i++) {
//            String vnd1 = contractList.get(i).getContractDeposit();
//            long VND = Long.valueOf(vnd1);
//            String vnd2 = currencyVN.format(VND);
//            contractList.get(i).setContractDeposit(vnd2);
//        }
//        contractPage = new PageImpl<>(contractList);
//        return contractPage;
//    }