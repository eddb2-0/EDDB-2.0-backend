package io.edpn.backend.trade.application.dto.web.object.mapper;

import io.edpn.backend.trade.application.domain.PageInfo;
import io.edpn.backend.trade.application.dto.web.object.PageInfoDto;

public interface PageInfoDtoMapper {

    <T extends PageInfoDto> T map(PageInfo pageInfo);
}
