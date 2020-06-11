package com.smart.patry.business.dto.apply;

import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/27,23:45 @Version: @Package:
 * com.smart.patry.business.dto.apply 注解解释：
 */
@Data
public class SelectEntry implements Serializable {
  private static final long serialVersionUID = -1780200722694760157L;
  /** 选中的积极分子申请 */
  private List<PatryApply> list;

  private List<PatryMember> patryMember;
  /** 党期 */
  private String patryApplyPatryperiod;
}
