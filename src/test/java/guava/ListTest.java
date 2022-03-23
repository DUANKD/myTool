package guava;

import com.mytool.base.utils.DateUtil;
import com.mytool.model.ActCenterResultVO;
import com.mytool.model.TblOperationActiveDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * <p>
 *
 * @author duankd/duankaida@bigo.sg
 * @version 1.0
 * @date 2022/3/14.
 */
public class ListTest {

    @Test
    public void name() {
        //获取进行中的活动
        List<TblOperationActiveDTO> ongoingActList = new ArrayList<>();
        {
            TblOperationActiveDTO dto = new TblOperationActiveDTO();
            dto.setName("dto1");
            ongoingActList.add(dto);
        }
        {
            TblOperationActiveDTO dto = new TblOperationActiveDTO();
            dto.setName("dto2");
            ongoingActList.add(dto);
        }
        {
            TblOperationActiveDTO dto = new TblOperationActiveDTO();
            dto.setName("dto3");
            ongoingActList.add(dto);
        }

        //然后还需要获取已经下线的最近3个活动
        List<TblOperationActiveDTO> topThreeOfflineActList = new ArrayList<>();
        {
            TblOperationActiveDTO dto = new TblOperationActiveDTO();
            dto.setName("dto4");
            topThreeOfflineActList.add(dto);
        }
        {
            TblOperationActiveDTO dto = new TblOperationActiveDTO();
            dto.setName("dto5");
            dto.setStartTime(new Date());
            dto.setEndTime(new Date());

            topThreeOfflineActList.add(dto);
        }
        List<TblOperationActiveDTO> totalList = new ArrayList<>(ongoingActList);
        CollectionUtils.addAll(totalList, topThreeOfflineActList);
        List<ActCenterResultVO> result = transformToActCenterResultVOList(totalList);
        System.out.println("RUN RESULT：\n" + result);
    }

    private static List<ActCenterResultVO> transformToActCenterResultVOList(List<TblOperationActiveDTO> resultList) {
        if (CollectionUtils.isEmpty(resultList)) {
            return new ArrayList<ActCenterResultVO>();
        } else {
            List<ActCenterResultVO> list = new ArrayList<ActCenterResultVO>();
            resultList.forEach(temp -> {
                ActCenterResultVO actCenterResultVO = transformToActCenterResultVO(temp);
                if (null != actCenterResultVO) {
                    list.add(actCenterResultVO);
                }
            });
            return list;
        }
    }

    private static ActCenterResultVO transformToActCenterResultVO(TblOperationActiveDTO dto) {

        if (null == dto) {
            return null;
        } else {
            ActCenterResultVO result = new ActCenterResultVO();
            result.setName(dto.getName());
            result.setLink(dto.getLink());
            result.setSummary(dto.getSummary());
            result.setIcon(dto.getIcon());
            Optional.ofNullable(dto.getStartTime()).ifPresent(t -> result.setStartTime(DateUtil.toUnixTime(dto.getStartTime())));
            Optional.ofNullable(dto.getStartTime()).ifPresent(t -> result.setStartTime(DateUtil.toUnixTime(t)));
            Optional.ofNullable(dto.getEndTime()).ifPresent(t -> result.setEndTime(DateUtil.toUnixTime(t)));
            //result.setEndTime(DateUtil.toUnixTime(dto.getEndTime()));
            result.setMinVersion(dto.getMinVersion());
            result.setRank(dto.getRank());
            return result;
        }

    }
}
