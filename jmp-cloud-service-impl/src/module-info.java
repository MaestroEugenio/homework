import com.cloud.service.impl.BankService;
import com.service.api.Service;

module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    provides Service with BankService;
    exports com.cloud.service.impl;
}