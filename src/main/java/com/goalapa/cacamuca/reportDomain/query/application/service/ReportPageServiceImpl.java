package com.goalapa.cacamuca.reportDomain.query.application.service;

import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.domain.entity.ReportQuery;
import com.goalapa.cacamuca.reportDomain.query.domain.repository.ReportMapper;
import com.goalapa.cacamuca.reportDomain.query.domain.service.ReportPageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportPageServiceImpl implements ReportPageService {

    private final ReportMapper reportMapper;

    public ReportPageServiceImpl(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    @Override
    @Transactional
    public Page<ReportQueryDTO> getReportPage(Pageable pageable) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("offset", (int) pageable.getOffset());
        pageMap.put("pageSize", pageable.getPageSize());

        List<ReportQueryDTO> reportList = reportMapper.getReportPage(pageMap);
        reportList.forEach(System.out::println);

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), reportList.size());

        // PageImpl -> 리스트를 page로 변환
        return new PageImpl<>(reportList.subList(start, end), pageable, reportList.size());
    }
}
