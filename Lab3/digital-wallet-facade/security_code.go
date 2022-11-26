package digital_wallet

import "fmt"

type SecurityCode struct {
	code string
}

func newSecurityCode(code string) *SecurityCode {
	return &SecurityCode{
		code: code,
	}
}

func (s *SecurityCode) checkCode(incomingCode string) error {
	if s.code != incomingCode {
		return fmt.Errorf("Security Code is incorrect")
	}
	fmt.Println("SecurityCode Verified")
	return nil
}
