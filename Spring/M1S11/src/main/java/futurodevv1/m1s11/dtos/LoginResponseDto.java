package futurodevv1.m1s11.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto
{
    private String type;
    private String token;
}
