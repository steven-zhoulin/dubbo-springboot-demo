package com.topsail.crm.order.cell.demo.sequence;

import com.asiainfo.areca.framework.database.sequence.AbstractSequence;
import com.asiainfo.areca.framework.util.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author Steven
 * @date 2020-02-10
 */
@Component
public class ImpExpLogSeq extends AbstractSequence {

    private String dataSource = "base";
    private String sequenceName = "SEQ_IMPEXP_LOG";

    @Override
    public Long nextval() {
        Long nextval = nextval(this.dataSource, this.sequenceName);
        String strNextval = StringUtils.leftPad(String.valueOf(nextval), 8, '0');
        String timestamp = TimeUtils.now("yyyyMM");
        return Long.parseLong(timestamp + strNextval);
    }
}
