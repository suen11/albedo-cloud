/*
 *  Copyright (c) 2019-2020, somowhere (somewhere0813@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.albedo.java.modules.sys.service.impl;

import com.albedo.java.common.core.util.CollUtil;
import com.albedo.java.modules.sys.domain.DeptRelation;
import com.albedo.java.modules.sys.repository.DeptRelationRepository;
import com.albedo.java.modules.sys.service.DeptRelationService;
import com.albedo.java.modules.sys.vo.DeptDataVo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author somowhere
 * @since 2019/2/1
 */
@Service
@AllArgsConstructor
public class DeptRelationServiceImpl extends ServiceImpl<DeptRelationRepository, DeptRelation> implements DeptRelationService {
	private final DeptRelationRepository deptRelationRepository;

	/**
	 * 维护部门关系
	 *
	 * @param deptDataVo 部门
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveDeptRelation(DeptDataVo deptDataVo) {
		//增加部门关系表
		DeptRelation condition = new DeptRelation();
		condition.setDescendant(deptDataVo.getParentId());
		List<DeptRelation> relationList = deptRelationRepository
			.selectList(Wrappers.<DeptRelation>query().lambda()
				.eq(DeptRelation::getDescendant, deptDataVo.getParentId()))
			.stream().map(relation -> {
				relation.setDescendant(deptDataVo.getId());
				return relation;
			}).collect(Collectors.toList());
		if (CollUtil.isNotEmpty(relationList)) {
			this.saveBatch(relationList);
		}

		//自己也要维护到关系表中
		DeptRelation own = new DeptRelation();
		own.setDescendant(deptDataVo.getId());
		own.setAncestor(deptDataVo.getId());
		deptRelationRepository.insert(own);
	}

	/**
	 * 通过ID删除部门关系
	 *
	 * @param id
	 */
	@Override
	public void removeDeptRelationById(String id) {
		baseMapper.deleteDeptRelationsById(id);
	}

	/**
	 * 更新部门关系
	 *
	 * @param relation
	 */
	@Override
	public void updateDeptRelation(DeptRelation relation) {
		baseMapper.updateDeptRelations(relation);
	}

}
