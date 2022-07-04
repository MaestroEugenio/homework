import com.service.api.Service;

module AppServiceLoader {
    requires jmp.bank.api;
    requires jmp.service.api;
    uses Service;
}